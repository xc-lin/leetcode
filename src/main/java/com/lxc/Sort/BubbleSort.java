package com.lxc.Sort;

import java.util.Arrays;

public class BubbleSort {
    public int[] bubbleSort(int[] nums) {
        // 用来判断是否有交换
        boolean flag = false;
        // 这表示需要多少次的循环
        // 如果有5位数，执行了四次 那么就说明最大值都已经在队尾 那么只剩一个就不需要排序了
        for (int i = 0; i < nums.length-1; i++) {
            // 因为一次冒泡就会吧一个最大值放到队尾 队尾元素就不需要在检查了一定比当前值大
            for (int j = 0; j < nums.length - i - 1; j++) {
                // 若相等则不交换 保证了算法的稳定性
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return nums;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BubbleSort().bubbleSort(new int[]{5, 4, 3, 2, 1})));
    }
}