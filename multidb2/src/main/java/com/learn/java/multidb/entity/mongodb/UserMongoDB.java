package com.learn.java.multidb.entity.mongodb;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document("user")
public class UserMongoDB implements Serializable {

		private static final long serialVersionUID = 8357509446499778255L;

		@Id
		private String id;

		private String userName;
}
