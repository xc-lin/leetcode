package com.lxc.JZOffer2;

public class J64_NumNums {
    public int sumNums(int n) {
        int result = 1;
        boolean a = ((n == 1) || (result = (n + sumNums(n - 1))) == 0);
        return result;
    }

    public static void main(String[] args) {
        new J64_NumNums().sumNums(3);
    }
}
