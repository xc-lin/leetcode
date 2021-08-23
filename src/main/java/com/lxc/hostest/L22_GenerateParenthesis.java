package com.lxc.hostest;

import java.util.ArrayList;
import java.util.List;

public class L22_GenerateParenthesis {
    List<String > result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n==0){
            return new ArrayList<>();
        }
        recur("",n,n);
        return result;
    }
    public void recur(String str,int left, int right){
        if (left==0&&right==0){
            result.add(str);
            return;
        }
        if (left==right){
            recur(str+"(",left-1,right);
        }
        if (left<right){
            if (left>0){
                recur(str+"(",left-1,right);
            }
            recur(str+")",left,right-1);
        }
    }
}
