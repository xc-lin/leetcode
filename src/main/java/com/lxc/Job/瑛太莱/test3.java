package com.lxc.Job.瑛太莱;

public class test3 {
    public static boolean find(int[][] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int m = arr.length;
        int n = arr[0].length;
        int i = 0;
        int j = n - 1;
        while (i >= 0 && i < m && j >= 0 && j < n) {
            int val=arr[i][j];
            System.out.println(val);

            if (val==target){
                return true;
            }else if (val<target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
