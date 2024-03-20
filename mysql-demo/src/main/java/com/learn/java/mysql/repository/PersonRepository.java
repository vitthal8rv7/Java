package com.learn.java.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.mysql.model.entity.Name;
import com.learn.java.mysql.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Name>{

}
