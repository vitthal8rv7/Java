package com.learn.java.multidb.repository.mysql.db1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.java.multidb.entity.mysql.db1.UserDB1;

public interface UserDB1Repository extends JpaRepository<UserDB1, Long> {

	public UserDB1 findByUserNameIgnoreCase(String userName);
}
