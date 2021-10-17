package com.lxc.Job.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {
    static int n;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) {
        n = new Scanner(System.in).nextInt();
        visited =new boolean[n];
        dfs(0);
        System.out.println(list.size());
        int size = list.size()>100?100:list.size();
        for (int i = 0; i < size; i++) {
            String s=list.get(i).toString();
            for (int j = 0; j < n; j++) {
                System.out.print(s.charAt(j)+" ");
            }
            System.out.println();

        }
    }

    public static void dfs( int pos) {
        if (pos>=n) {
            list.add(sb.toString());
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]&&i!=pos){
                visited[i]=true;
                sb.append(i+1);
                dfs(pos+1);
                visited[i]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
