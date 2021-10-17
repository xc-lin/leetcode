package com.lxc.Job.qunaer;

import java.util.Arrays;
import java.util.Scanner;

class test2_1 {
    /* Write Code Here */
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int sum=0;
        int max[]=new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--) {
            max[i]=sum;
            sum+=arr[i];
        }
        sum=0;
        int count=1;
        for (int i = 0; i < arr.length; i++) {
            if (count*arr[i]+max[i]>0){
                sum+=(count++)*arr[i];
            }
        }
        return sum;

    }
}

public class test2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = new test2_1().solution(_arr);
        System.out.println(String.valueOf(res));

    }
}
