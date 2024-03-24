package com.learn.java.multidb.model.dto;

import java.io.Serializable;

import com.learn.java.multidb.model.collection.UserMongoDB;
import com.learn.java.multidb.model.entity.UserMysqlDB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDto implements Serializable {
	
	private static final long serialVersionUID = 8639931080912042162L;

	private UserMysqlDB userMysqlDB;
	
	private UserMongoDB userMongoDB;
}
