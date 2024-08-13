package com.java.learning.security.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
//
//    @GetMapping("/home5")
//    public String index(@RequestParam(name = "name", required = true) String name) {
//        System.out.println(name.length());
//        int size = (Integer) name.length();
//        for (int i = 1; i <= name.length() / 2; i++) {
//            boolean is9Found = false;
//            for (int j = 0; j + i < size; j = j + i) {
//                System.out.println("i = " + i + " j = " + j);
//                try{
//                    String substring1 = null;
//                    String substring2 = null;
//                    if(is9Found) {
//                        substring1 = name.substring(j, j + i + i);
//                        substring2 = name.substring(j + i + i, (j + i + i + i + i));
//                    } else {
//                        substring1 = name.substring(j, j + i);
//                        substring2 = name.substring(j + i, (j + i + i));
//                    }
//
//                    if((substring1.equalsIgnoreCase("9")) ||  (substring1.length() > 1 && substring1.charAt(substring1.length() - 1) == '9' && substring1.charAt(substring1.length() - 2) == '9')){
//                        if(substring1.equalsIgnoreCase("9")) {
//                            substring2 = name.substring(j + i, (j + i + i + i));
//                        } else {
//                            substring2 = name.substring(j + i, (j + i + i + i + 1));
//                        }
//                        is9Found = true;
//                    }
//                    System.out.println(substring1 + " " + substring2);
//                } catch (Exception e) {
//                    break;
//                }
//            }// For j
//        }// For i
//        return name;
//    }
//


//    @GetMapping("/home4")
//    public String index4(@RequestParam(name = "name", required = true) String name) {
//
//        Integer value = Integer.parseInt(name);
//        System.out.println("value: "+value);
//        Integer divideCounter = 1;
//        Integer outerDivider = 10;
//        for(int i = 1; i < name.length() - divideCounter; i++) {
//            outerDivider = outerDivider * 10;
//        }
//        System.out.println("outerDivider: "+outerDivider);
//        while(value > 0) {
//            Integer divider = outerDivider;
//            Integer number1 = value / divider;
//            Integer number2 = null;
//            System.out.print("number1: "+number1);
//
//            if(number1 == 9) {
//                Integer value2 = value*100 / divider;
//                //divider = divider * 10;
//                number2 = value % divider;
//                System.out.println(" number2: "+number2);
//            }
//            value = value % divider;
//            //System.out.println(value);
//        }
//
//
//        return "processComplete";
//    }
//
//    @GetMapping("/home3")
//    public String index(@RequestParam(name = "name", required = true) String name) {
//        String s = name;
//        System.out.println(s.length());
//        int size = (Integer) s.length();
//        for (int i = 1; i <= s.length() / 2; i++) {
//            int k = i;
//            boolean is10Found = false;
//            for (int j=0; j+k<size; j=j+k) {
//                System.out.println("i = " + k + " j = " + j);
//                String substring1 = s.substring(j, j + k);
//                int integer1 = Integer.parseInt(substring1);
//                String substring2 = null;
//                try {
//                    if (integer1 % 10 == 9) {
//                        substring2 = s.substring(j + k, (j + k + k + 1));
//                        is10Found = true;
//                    } else {
//                        substring2 = s.substring(j + k, (j + k + k));
//                    }
//                } catch (Exception e) {
//                    System.out.println(substring1 + " " + substring2 + " break");
//                    break;
//                }
//                if (is10Found) {
//                    if (j == 0)
//                        j = j + 1;
//                    k = k + 1;
//                    is10Found = false;
//                }
//                System.out.println("i = " + k + " j = " + j);
//                System.out.println((k + j) < size);
//                System.out.println(substring1 + " " + substring2);
//
//            }// For j
//        }// For i
//
//
//        return "Hello World";
//    }

    @GetMapping("/home")
    public String home() {
        return "Welcome Home";
    }

    @GetMapping("/home2")
    public String home2() {
        return "Welcome Home";
    }
}
