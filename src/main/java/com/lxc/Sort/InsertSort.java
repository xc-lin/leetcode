package com.lxc.Sort;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertSort {
    public int[] insertSort(int[] nums) {
        // 算法思想主要是对数组的每一个数与前面的数对比将他放置在对的位置
        // 从第1个数开始因为第0个数的前面是空的
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j;
            // 查看这个数的前面所有数字
            for (j = i - 1; j >= 0; j--) {
                // 如果前面的数字大于自己 那么将这个数字后移
                // 一旦出现一个数小于等于自身，那么说明这个数的前面所有数都满足小于等于自身
                // 因为此算法的本质就是分段排序 自身的前面所有数字都已经有序
                if (temp < nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = temp;

        }
        return nums;
    }

    public int[] insertSortBinary(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            // 左边界
            int left = 0;
            // 右边界
            int right = i - 1;
            // 从图中我们可以看出当左边界大于有边界时就找到了对应的位置，位置是最后left所指向的位置
            while (left > right) {
                int mid = (left + right) / 2;
                if (nums[mid] > temp) {
                    right = mid - 1;
                } else {
                    // 让相等的情况走这个语句，这样可以保持稳定性
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                nums[j+1]=nums[j];
            }
            nums[left]=temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new InsertSort().insertSortBinary(new int[]{5, 4, 3, 2, 1})));
    }
}
