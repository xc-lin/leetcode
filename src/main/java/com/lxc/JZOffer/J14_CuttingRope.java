package com.lxc.JZOffer;

public class J14_CuttingRope {

    public int cuttingRope(int n) {
        if (n<=3){
            return n-1;
        }
        int a = n/3;
        int result=0;
        if (n%3==1){
            result= (int)Math.pow(3,a-1)*4;
        }else if (n%3==0){
            result= (int)Math.pow(3,a);
        }else {
            result= (int)Math.pow(3,a);
            result*=2;
        }
        return result;
    }
}
