package com.lxc.JZOffer;

import java.util.HashMap;
import java.util.Map;

public class J56_SingleNumber {
    public static void main(String[] args) {
        System.out.println(new J56_SingleNumber().singleNumber2(new int[]{1, 1, 6, 1}));
    }

    public int singleNumber2(int[] nums) {
        // 记录数组中每一个数字的每一位出现的次数
        int count[] = new int[32];
        // 对数组中每一个数都统计一次二进制位出现1 的次数
        for (int num : nums) {
            int m = 1;
            // 统计一个数中每一位二进制位1的次数
            for (int i = 0; i < 32; i++) {
                // 这样得到的比如是100 需要将它重新右移回去
                if ((num & m) >> i == 1) {
                    count[i] += 1;
                }
                m <<= 1;
            }
        }
        // 以为他们出现的次数都是3次，所以单独出现的那个数字一定就是%3 剩下的那个
        for (int i = 0; i < 32; i++) {
            count[i] %= 3;
        }
        int result = 0;

        for (int i = 0; i < 32; i++) {

            // count此时数组中只有0和1 如果是1 说明结果的第i位需要是1
            if (count[i] == 1) {
                int m = 1;
                // 因为是第i位是1
                // 那么我们需要将m左移m位，然后与result或 这样就可以把1赋值给第i位的result了
                m = m << i;
                result |= m;
            }
        }
        return result;
    }


    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, false);

            } else {
                map.put(num, true);
            }
        }
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }


}
