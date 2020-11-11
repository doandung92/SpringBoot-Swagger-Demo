package com.evolyb.swagger.repository;

import com.evolyb.swagger.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
