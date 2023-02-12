package com.peaksoft.service.impl;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Student;
import com.peaksoft.entity.Teacher;
import com.peaksoft.repository.CourseRepository;
import com.peaksoft.repository.StudentRepository;
import com.peaksoft.repository.TeacherRepository;
import com.peaksoft.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }
    @Override
    public void addTeacher(Teacher teacher,Long courseId) {
        Course course = courseRepository.getById(courseId);
        teacher.setCourse(course);
        teacherRepository.save(teacher);

    }

    @Override
    public void updateTeacher(Long id, Teacher teacher,Long courseId) {
        Teacher teacher1 = teacherRepository.getById(id);
        Course course = courseRepository.getById(courseId);
        teacher1.setCourse(course);
        teacher1.setEmail(teacher.getEmail());
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacherRepository.save(teacher1);
    }
    @Override
    public Teacher getById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public Long getStudentsByTeacherId(Long id) {
        return teacherRepository.getCoursesByTeacherId(id);
    }
}
