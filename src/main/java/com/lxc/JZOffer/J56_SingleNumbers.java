package com.lxc.JZOffer;

import java.util.HashMap;

public class J56_SingleNumbers {
    public int[] singleNumbersBest(int[] nums) {
        // 首先，自己和自己异或得出来是0；0与其他数字异或得其他数字本身
        // 通过这个特性，我们可知如果一个数组中只有一个数字出现一次
        // 其他数字出现两次，那么全员异或（满足交换律）得到的值就是出现一次的那个值
        // 但是这一题，数组中有两个数字出现一次
        // 因此我们需要吧两个出现一次的数组分开处理

        int z = 0, m = 1, a = 0, b = 0;
        for (int num : nums) {
            z = z ^ num;
        }
        // z最终得到值是两个出现一次的值的异或操作其中为1的地方是两个数二进制中不一样的位置

        // 因为异或操作在值不一样时为1
        // 通过这个while循环我们找到第一个 两个数不一样的二进制位置
        // 我们找到m=100说明这两个数的第三位是不一样的 因为我们重新遍历nums 让他们分别与m与 两个出现一次的数得到的与的结果一定不同
        // 但是那些两个值一样的数字 与m与结果一定相同
        while ((z & m) == 0) {
            m <<= 1;
        }
        for (int num : nums) {
            if ((num & m) == 0) {
                // 一个出现一次的数在这里他分别和其他数异或 最终得到的就是第一个只出现一次的数
                a = a ^ num;
            } else {
                // 第二个出现一次的数在这里他分别和其他数异或 最终得到的就是第二个只出现一次的数
                b = b ^ num;
            }
        }
        return new int[]{a, b};
    }

    public int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, num);
            }
        }
        int result[] = new int[2];
        int count = 0;
        for (int a : map.keySet()) {
            result[count++] = a;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 1 ^ 7;
        System.out.println(a);
    }
}
