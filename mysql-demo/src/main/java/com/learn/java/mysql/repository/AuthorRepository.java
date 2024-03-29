package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

}
