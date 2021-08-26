package com.lxc.byteDance;

public class 最小未出现整数 {
    public static void main(String[] args) {
        int arr[] = new int[]{3, 2, 4, };
        if (arr == null || arr.length == 0) {
            return;
        }
        int LEN = arr.length;
        for (int i = 0; i < LEN; i++) {
            // 把每个数字都放到正确的位置上
            //大于0小于arr长度+1的数据n 与 原数组中下标为 n-1 的数据 进行交换
            while (arr[i] <= LEN && arr[i] >= 1 && arr[i] != i + 1) {
                if (arr[i] == arr[arr[i] - 1]) {
                    break;
                }
                swap(arr, i, arr[i] - 1);
            }
        }

        //将 当前数据n 和 下标为n-1 的值 不相等的一个数据
        for (int i = 0; i < LEN; i++) {
            if (arr[i] != i + 1) {
                System.out.println(i + 1);
                break;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
