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

    private static final long serialVersionUID = -6941008488901155547L;

    private Integer count;
}