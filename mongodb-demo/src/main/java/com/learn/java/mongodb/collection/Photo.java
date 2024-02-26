package com.learn.java.mongodb.collection;

import java.io.Serializable;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("photo")
@JsonInclude(Include.NON_NULL)
public class Photo implements Serializable {

	private static final long serialVersionUID = 8657014830755038405L;

	@Id
	private String id;
	private String title;
	private Binary photo;
}
