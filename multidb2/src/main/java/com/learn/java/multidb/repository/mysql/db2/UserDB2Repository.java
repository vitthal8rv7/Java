package com.learn.java.multidb.repository.mysql.db2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.java.multidb.entity.mysql.db2.UserDB2;

public interface UserDB2Repository extends JpaRepository<UserDB2, Long> {

	public UserDB2 findByUserNameIgnoreCase(String userName);
}
