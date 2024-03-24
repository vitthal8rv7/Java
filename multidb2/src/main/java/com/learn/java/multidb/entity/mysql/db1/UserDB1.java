package com.learn.java.multidb.entity.mysql.db1;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class UserDB1 implements Serializable {

		private static final long serialVersionUID = 8357509446499778255L;

		@jakarta.persistence.Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String userName;
}
