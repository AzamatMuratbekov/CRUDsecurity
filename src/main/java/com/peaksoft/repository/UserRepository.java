package com.peaksoft.repository;

import com.peaksoft.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select e from User e where e.email = :email")
    User getUserByEmail(@Param("email")String email);
}
