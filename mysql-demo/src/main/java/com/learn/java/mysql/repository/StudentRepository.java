package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.java.mysql.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
