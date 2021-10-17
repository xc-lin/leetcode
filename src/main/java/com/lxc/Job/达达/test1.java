package com.lxc.Job.达达;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        char[] chars1 = line1.toCharArray();
        char[] chars2 = line2.toCharArray();
        Map<Character,Integer> map= new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {
            map.put(chars1[i],i);
        }
        int a=0,b=0;

        for (int i = 0; i < chars1.length; i++) {
            if (chars2[i]==chars1[i]){
                a++;
            }else {
                Integer index = map.getOrDefault(chars2[i], -1);
                if (index!=-1) {
                    map.put(chars2[i],-1);
                    b++;
                }

            }
        }
        System.out.println(a+"Z"+b+"C");
    }
}
