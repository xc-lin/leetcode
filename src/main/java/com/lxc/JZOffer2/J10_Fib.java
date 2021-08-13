package com.lxc.JZOffer2;

public class J10_Fib {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int prepre=0;
        int pre=1;
        for (int i = 0; i < n-1; i++) {
            int curr= pre+prepre;
            prepre=pre;
            pre=curr%1000000007;
        }
        return pre;
    }
}