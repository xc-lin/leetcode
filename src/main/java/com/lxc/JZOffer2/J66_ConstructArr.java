package com.lxc.JZOffer2;

public class J66_ConstructArr {
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int left[] = new int[a.length];
        int right[] = new int[a.length];
        left[0] = a[0];
        right[a.length - 1] = a[a.length - 1];
        for (int i = 1; i < a.length; i++) {
               left[i]=a[i]*left[i-1];
        }
        for (int i = a.length-2; i >=0; i--) {
            right[i]=a[i]*right[i+1];
        }
        int result[]=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int leftNum=0;
            if (i==0){
                leftNum=1;
            }else {
                leftNum=left[i-1];
            }
            int rightNum=0;
            if (i==a.length-1){
                rightNum=1;
            }else {
                rightNum=right[i+1];
            }
            result[i]=leftNum*rightNum;
        }
        return result;
    }
}
