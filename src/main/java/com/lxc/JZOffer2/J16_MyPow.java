package com.lxc.JZOffer2;

public class J16_MyPow {
    // 二分法
    public double myPow(double x, int n) {
        // 要注意n可能是-2^31
        // -n导致直接直接越界因为int是 2^31-1<n<2^31
        long tempN=n;
        if (tempN == 0) {
            return 1;
        }
        if (tempN < 0) {
            // 如果n小于0，那么直接算一个倒数
            x = 1 / x;
            tempN=-tempN;
        }
        if (tempN == 1) {
            return x;
        }
        if (tempN % 2 == 1) {
            double temp = myPow(x, (int)(tempN - 1) / 2);
            return temp * temp * x;
        } else {
            double temp = myPow(x, (int)(tempN / 2));
            return temp * temp;
        }
    }

    public double myPowBest(double x, int n) {
        if (x==0){
            return 0;
        }
        if (n==0){
            return 1;
        }
        long tempN=n;
        double result=1.0;
        if (n<0){
            x=1/x;
            tempN=-tempN;
        }
        // 如果是10^9 9=1001 9=2^1+2^3
        // 如果是
        while (tempN!=0){
            if ((tempN&1)==1) {
                result *= x;
            }
            // 第一次结束是10*10=10^2
            // 第二次结束是 10^2*10^2=10^4
            // 第三次结束是 10^4*10*4=10^8
            x*=x;
            tempN>>=1;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new J16_MyPow().myPow(2.00000, -2147483648));
    }
}
