package com.lxc.Job.渤海银行;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        scanner.nextLine();
        String line =scanner.nextLine();
        String[] strings=line.split( " ");
        Map<String ,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(strings[i],map.getOrDefault(strings[i],0)+1);
        }
        int result=0;
        for (Map.Entry<String ,Integer> entry: map.entrySet()){
            if (entry.getValue()%2!=0){
                result++;
            }
        }
        System.out.println(result);
    }
}
