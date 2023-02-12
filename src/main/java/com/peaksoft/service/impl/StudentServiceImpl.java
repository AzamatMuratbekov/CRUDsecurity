package com.peaksoft.service.impl;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import com.peaksoft.repository.GroupRepository;
import com.peaksoft.repository.StudentRepository;
import com.peaksoft.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    @Override
    public void addStudent(Student student,Long groupId) {
        Group group = groupRepository.getById(groupId);
        student.setGroup(group);
        studentRepository.save(student);
    }
    @Override
    public void updateStudent(Long id, Student student,Long groupId) {
        Student student1 = studentRepository.getById(id);
        student1.setFirstName(student.getFirstName());
        student1.setEmail(student.getEmail());
        student1.setLastName(student.getLastName());
        Group group = groupRepository.getById(groupId);
        student.setGroup(group);
        studentRepository.save(student1);
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudent(Student student) {
       studentRepository.delete(student);
    }
}
