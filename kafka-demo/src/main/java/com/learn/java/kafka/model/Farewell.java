package com.learn.java.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farewell {//implements Serializable {
//	private static final long serialVersionUID = -794826595677910128L;
	private String id;
	private String name;
}
