package com.lxc.Job.电信;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] cs = line.toCharArray();
        int length=cs.length;
        int opt[]=new int[length];
        opt[0] =1;
        Map<Character,Integer> map=new HashMap<>();
        map.put(cs[0],0);
        int result=1;
        for (int i =1; i < length; i++) {
            if (map.containsKey(cs[i])&&map.get(cs[i])+opt[i-1]>=i){
                opt[i]=i-map.get(cs[i]);
            }else {
                opt[i] = opt[i-1]+1;
            }
            result=Math.max(opt[i],result);
            map.put(cs[i],i);
        }
        System.out.println(result);


    }
}
