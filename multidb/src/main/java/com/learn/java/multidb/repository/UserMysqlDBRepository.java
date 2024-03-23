package com.learn.java.multidb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.java.multidb.model.entity.UserMysqlDB;

@Repository
public interface UserMysqlDBRepository extends JpaRepository<UserMysqlDB, String> {

}
