package com.peaksoft.repository;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Query("select c from Course c join c.company com where com.id=:id")
    List<Course> getCoursesByCompanyId(@Param("id") Long id);

    @Query("SELECT count(s.id) from Student s  join Group g on g.id = s.group.id join Course c on c.id = g.course.id join Company c2 on c2.id = c.company.id where c2.id=:id")
   Long getStudentsByCompanyId(@Param("id") Long id);
    }
