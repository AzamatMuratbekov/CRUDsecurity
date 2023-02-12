package com.peaksoft.service.impl;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import com.peaksoft.repository.CourseRepository;
import com.peaksoft.repository.GroupRepository;
import com.peaksoft.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;
    @Override
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }
    @Override
    public void addGroup(Group group, Long courseId) {
        Course course = courseRepository.getById(courseId);
        group.setCourse(course);
        groupRepository.save(group);

    }

    @Override
    public void updateGroup(Long id, Group group, Long courseId) {
        Group group1 = groupRepository.getById(id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
       Course course = courseRepository.getById(courseId);
        group.setCourse(course);
        groupRepository.save(group1);
    }

    @Override
    public Group getById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public void deleteGroup(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public Student search(String name) {
        return groupRepository.search(name);
    }

}
