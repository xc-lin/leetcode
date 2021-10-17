package com.lxc.Job.qunaer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class test1_1 {
    public String solution(int[] d) {
        Arrays.sort(d);
        this.d = d;
        dfs(0,d.length-1,d.length);
        return result;
    }

    int[] d;
    StringBuilder sb = new StringBuilder();
    String result="";

    public void dfs(int sum, int depth, int n) {
        if (sum%3==0){
            if (sb.length()!=result.length()){
                result=sb.length()>result.length()?sb.toString():result;
            }else if (sb.toString().compareTo(result)>0){
                result=sb.toString();
            }
        }
        if (depth == -1) {
            return;
        }
        for (int i = depth; i >=0; i--) {
            sb.append(d[i]);
            dfs(sum + d[i],i-1,n);
            sb.deleteCharAt(sb.length()-1);

        }
    }
}

public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        int _d_size = 0;
        _d_size = Integer.parseInt(in.nextLine().trim());
        int[] _d = new int[_d_size];
        int _d_item;
        for (int _d_i = 0; _d_i < _d_size; _d_i++) {
            _d_item = Integer.parseInt(in.nextLine().trim());
            _d[_d_i] = _d_item;
        }

        res = new test1_1().solution(_d);
        System.out.println(res);
    }
}

