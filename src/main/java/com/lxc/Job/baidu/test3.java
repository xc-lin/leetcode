package com.lxc.Job.baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        int[][] max = new int[n][n];
        int[][] min = new int[n][n];
        int result=0;
        for (int i = 0; i < n; i++) {
            max[i][i]=1;
        }
        for (int i = 1; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    min[i][j] = 1;
                    max[i][j] = max[i][j-1];
                }else {
                    min[i][j]=min[i][j-1]+1;
                    max[i][j]=max[i][j-1]+1;
                }
                if (k<=max[i][j]&&k>=min[i][j]){
                    result++;
                }
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            }
        }
        System.out.println(result);
    }
}
