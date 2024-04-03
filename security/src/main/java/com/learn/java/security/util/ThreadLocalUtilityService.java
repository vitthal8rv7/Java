package com.learn.java.security.util;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ThreadLocalUtilityService {

    ThreadLocal<Long> t1 = new ThreadLocal<>();

    ThreadLocal<Long> t2 = new ThreadLocal<>();

    ThreadLocal<Long> t3 = new ThreadLocal<>();

    ThreadLocal<Long> t4 = new ThreadLocal<>();

}
