package com.learn.java.mysql.model.entity;


import static java.lang.System.currentTimeMillis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class Auditing {
	

	@CreationTimestamp
	private LocalDate createdDate;

	@CreationTimestamp
	private LocalTime createdTime;

	@CreationTimestamp
	private LocalDateTime createdDateTime;

	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	private Date updatedDate;
	
	@Temporal(TemporalType.TIME)
	@UpdateTimestamp
	private Date updatedTime;
	
//	@Temporal(TemporalType.TIMESTAMP) //default
	@UpdateTimestamp
	private Date updatedDateTime;

	
	
	
	
	@CreatedDate // not working ==> null
	private Date createdDateAt;

	@LastModifiedDate// not working ==> null
	private Date modifiedDateAt;

	@CreatedBy // not working ==> null
	private String createdBy;

	@LastModifiedBy// not working ==> null
	private String modifiedBy;

	@PrePersist
	void setCreationData() {
		System.out.println("pre presist start...");
//		createdDate = java.time.LocalDate.now();
//		createdTime = java.time.LocalTime.now();
//		createdDateTime = java.time.LocalDateTime.now();
	
//		updatedDate = new Date(currentTimeMillis());
//		updatedTime = new Date(currentTimeMillis());
//		updatedDateTime = new Date(currentTimeMillis());
		
		System.out.println("pre presist end.");
	}
	
	@PostPersist
	void validateCreationData() {
		System.out.println("post presist start...");
		System.out.println("validate presisted data.");
		System.out.println("post presist end.");
	}

	
	@PreUpdate
	void setUpdationData() {
		System.out.println("pre update start...");
//		updatedDate = new Date(currentTimeMillis());
//		updatedTime = new Date(currentTimeMillis());
//		updatedDateTime = new Date(currentTimeMillis());
		System.out.println("pre update end.");
	}
	
	@PostUpdate
	void validateUpdatedData() {
		System.out.println("post update start...");
		System.out.println("validate updated data.");
		System.out.println("post update end.");
	}
	
	@PreRemove
	void preRemoval() {
		System.out.println("pre removal start...");
		System.out.println("take required actions.");
		System.out.println("pre removal end.");
	}
	
	@PostRemove
	void postRemoval() {
		System.out.println("post removal start...");
		System.out.println("take required actions.");
		System.out.println("post removal end.");
	}
	
	

}
