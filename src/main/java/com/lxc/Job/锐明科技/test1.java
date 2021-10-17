package com.lxc.Job.锐明科技;

public class test1 {
    public int[] bubbleSort (int[] array) {
        // write code here
        int length=array.length;
        for (int i = 0; i < length; i++) {
            boolean flag=true;
            for (int j = 1; j < length-i; j++) {
                if (array[j-1]<array[j]){
                    int temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                    flag=false;
                }
            }
            if (flag){
                return array;
            }

        }
        return array;
    }
}
