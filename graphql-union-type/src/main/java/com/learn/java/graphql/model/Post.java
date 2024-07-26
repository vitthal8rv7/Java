package com.learn.java.graphql.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post implements Serializable {

	private static final long serialVersionUID = -7930719055302146085L;

		private String id;		
	    private String title;
	    private String content;
}
