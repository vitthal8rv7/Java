package com.learn.java.mongodb.util;

import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.util.CollectionUtils;
import org.springframework.util.NumberUtils;

import io.micrometer.common.util.StringUtils;

public class MongoUtility {

	public static Boolean EMPTY = false;
	public static Boolean NON_EMPTY = true;
	public static Boolean isStringNotEmpty(String data) {
		if(StringUtils.isBlank(data)) {
			return EMPTY;
		} else {
			return NON_EMPTY;
		}
		
	}
	public static Boolean isFloatNotEmpty(Float data) {
		if(Objects.isNull(data)) {
			return EMPTY;
		} else {
			return NON_EMPTY;
		}
	}
	public static Boolean isCriteriaNotEmpty(List<Criteria> criterias) {
		if(CollectionUtils.isEmpty(criterias)) {
			return EMPTY;
		} else {
			return NON_EMPTY;
		}
	}

}
