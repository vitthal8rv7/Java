package com.learn.java.notification.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Mindstix
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountVO implements Serializable {

    public CountVO() {
	}

    public CountVO(Integer count) {
		this.count = count;
	}

	private static final long serialVersionUID = -6941008488901155547L;

    private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CountVO [count=" + count + "]";
	}
}