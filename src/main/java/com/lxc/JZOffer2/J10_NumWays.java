package com.lxc.JZOffer2;

public class J10_NumWays {
    public int numWays(int n) {
        if(n==0){
            return 1;
        }
        if (n==1){
            return 1;
        }
        int opt[] =new int[n+1];
        opt[0]=1;
        opt[1]=1;
        for (int i = 2; i < n+1; i++) {
            opt[i]=(opt[i-1]+opt[i-2])%1000000007;
        }
        return opt[n];
    }
}
