package com.learn.java.dsa.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class Example1 {

	public int[] twoSum(int[] nums, int target) {
		Long t1 = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                	System.out.println("=> "+i+" , "+j);
            		Long t2 = System.currentTimeMillis();
            		System.out.println("Time brute-force: "+ (t2-t1));
                    return new int[] { i, j };
                }
            }
        }
		Long t2 = System.currentTimeMillis();
		System.out.println("Time brute-force: "+ (t2-t1));

        throw new IllegalArgumentException("Invalid input");
    }
	
	public int[] twoSumWithHashmap(int[] nums, int target) {
		Long t2 = System.currentTimeMillis();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
		Long t3 = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            int result = map.getOrDefault(num, -1);
            if (result >= 0 && result != i) {
            	System.out.println("=> "+i+" , "+result);
                Long t4 = System.currentTimeMillis();
                System.out.println("Time hashmap: "+ (t4-t3));
                System.out.println("Time hashmap assignment: "+ (t3-t2));
                System.out.println("Time complete hashmap: "+ (t4-t2)); 
                
                return new int[] { i, result };
            }
        }
        Long t4 = System.currentTimeMillis();
        System.out.println("Time hashmap: "+ (t4-t3)); 
        System.out.println("Time hashmap assignment: "+ (t3-t2));
        System.out.println("Time complete hashmap: "+ (t4-t2)); 
        throw new IllegalArgumentException("invalid input");
    }
	
	public static void testExample1() {
		int[] nums = new int[100000];// {-2000000, 2000000,7000000,11000000,15000000}; 
		Random random = new Random(); 
		nums[0] = -2000000;
		nums[nums.length-1] = 2000000;
		for(int i = 1; i<99999; i++) {
			nums[i] = random.nextInt(-10000000, 90000000);
		}
		int target = 0;
		Example1 example1 = new Example1();
		example1.twoSum(nums, target);
		example1.twoSumWithHashmap(nums, target);
		
	}
	
}
/* Result
=> 0 , 99999
Time brute-force: 2
=> 0 , 99999
Time hashmap: 0
Time hashmap assignment: 16
Time complete hashmap: 16
*/
