package com.peaksoft.repository;
import com.peaksoft.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Query("select count(s.id) from Student s join Group g on g.id = s.group.id join Course c on c.id = g.course.id join Teacher t on t.id = c.teacher.id where t.id=:id")
    Long getCoursesByTeacherId(@Param("id") Long id);
}
