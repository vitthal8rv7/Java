package com.java.learning.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/home3")
    public String index() {

         try {
             String s = "99100";
            //System.out.println(s);
            if(s.length() == 0) {
                System.out.println("NO");
            } else if (s.length() == 1) {
                System.out.println("YES " + s);
            } else {
                //SubString size
                for (int i = 1; i <= s.length()/2; i++) {
                    Integer initial = -1;
                    Integer k = 0;
                    Integer l = i;
                    Boolean isIChanged =  false;
                    for (int j = 0; (j + i) < s.length(); j=j+i) {
                        k = j;
                        String substring1 = s.substring(j, j + i);
                        Integer integer1 = Integer.valueOf(substring1);
                        if(initial == -1) {
                            initial = integer1;
                        }
                        String substring2 = null;
                        try{
                            if(integer1%10 == 9){
                                substring2 = s.substring(j+i, j + i + i + 1);
                                i = i + 1;
                            } else {
                                substring2 = s.substring(j+i, j + i + i);
                            }

                        } catch (Exception e) {
                            System.out.println(substring1 + " " +substring2 + " break");
                            break;
                        }
                        //System.out.println(substring1 + " " +substring2);
                        Integer integer2 = Integer.valueOf(substring2);
                        if((integer2 - integer1) != 1) {
                           break;
                        }
                        System.out.println("j = "+j);
                    }// For j
                    if(isIChanged) {
                        i = l;
                    }
                    System.out.print("i = "+i);
                    System.out.println("  k = "+k);
                    System.out.println("length = "+s.length());
                    if( (k+i+1) >= s.length()/i) {
                        System.out.println("YES " + initial);
                        break;
                    } else {
                        System.out.println("NO");
                    }
                }// For i

            }
        } catch (Exception e) {
             e.printStackTrace();
         }



        return "Hello World";
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome Home";
    }

    @GetMapping("/home2")
    public String home2() {
        return "Welcome Home";
    }
}
