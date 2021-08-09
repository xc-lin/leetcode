package com.lxc.JZOffer;

public class J64_SumNums {
    int result = 0;

    public int sumNums(int n) {
        recur(1, n);
        return result;
    }

    int recur(int a, int n) {
        boolean k = (a <= n) && (result += a) > 0 && recur(++a, n) > 0;
        return 1;
    }

    public int sumNums2(int n) {
        recur2(n);
        return result;
    }

    int recur2(int n) {
        boolean k = (n > 1) && (n+=recur2(n - 1))>0;
        return n;
    }


}
