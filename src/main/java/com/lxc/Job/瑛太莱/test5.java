package com.lxc.Job.瑛太莱;

public class test5 {
   static int int_sqrt(int x) {
        for (int i = 0; i <=x; i++) {
            int iPlus=i+1;
            if (i*i<=x&&iPlus*iPlus>x){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(int_sqrt(9));
    }
}
