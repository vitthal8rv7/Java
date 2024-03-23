package com.learn.java.multidb.model.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class UserMysqlDB implements Serializable {

	private static final long serialVersionUID = 8357509446499778255L;

	@jakarta.persistence.Id
	private String id;

	private String userName;
}
