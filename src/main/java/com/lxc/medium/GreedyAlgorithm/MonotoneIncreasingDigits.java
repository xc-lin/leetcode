package com.lxc.medium.GreedyAlgorithm;

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        char strs[]=String.valueOf(n).toCharArray();
        for (int i = strs.length-1; i >=1 ; i--) {
            if(strs[i]>=strs[i-1]){

            }else {
                strs[i-1]-=1;
                for (int j = i; j < strs.length; j++) {
                    strs[j]='9';
                }

            }
        }
        return Integer.valueOf(String.valueOf(strs));
    }
}
