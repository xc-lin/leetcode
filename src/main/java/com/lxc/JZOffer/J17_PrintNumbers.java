package com.lxc.JZOffer;

public class J17_PrintNumbers {
    public int[] printNumbers(int n) {
        char []c=new char[n];
        for (int i = 0; i < n; i++) {
            c[i]='9';
        }

        String s=new String(c);
        int num= Integer.parseInt(s);
        int result[]=new int[num];
        for (int i = 1; i <= num; i++) {
            result[i-1]=i;
        }
        return result;
    }

    public int[] printNumbers2(int n) {
        int num= (int) Math.pow(10,n);
        int []result=new int[num-1];
        for (int i = 1; i < num; i++) {
            result[i-1]=i;
        }
        return result;
    }
}
