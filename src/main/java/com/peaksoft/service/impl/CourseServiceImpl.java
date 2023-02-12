package com.peaksoft.service.impl;
import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.repository.CompanyRepository;
import com.peaksoft.repository.CourseRepository;
import com.peaksoft.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void addCourse(Course course,Long companyId) {
        Company company = companyRepository.getById(companyId);
        course.setCompany(company);
        courseRepository.save(course);

    }

    @Override
    public void updateCourse(Long id, Course course,Long companyId) {
        Course course1 = courseRepository.getById(id);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        Company company = companyRepository.getById(id);
        course.setCompany(company);
        courseRepository.save(course1);
    }
    @Override
    public Course getById(Long id) {
           return courseRepository.findById(id).get();
    }
    @Override
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }
}
