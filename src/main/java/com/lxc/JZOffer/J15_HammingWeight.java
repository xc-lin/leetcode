package com.lxc.JZOffer;

public class J15_HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int result=0;
        for (int i = 0; i < 32; i++) {
            int k = n & mask << i;
            k=k>>i;
            if (i==31){
                int a=5;
            }
            if (k==1||k==-1) {
                result++;
            }
        }
        return result;
    }
    public int hammingWeight2(int n) {
        int mask = 1;
        int result=0;
        while (n!=0){
            result+=n&mask;
            n=n>>1;
        }
        return result;
    }
}
