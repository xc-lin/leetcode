package com.lxc.Job.科大讯飞;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class test1 {
    public int[] minimumNumber(int[] target) throws Exception {
        int max = target[0];
        int[] result = new int[target.length];
        for (int i = 1; i < target.length; i++) {
            max = Math.max(max, target[i]);
        }

        int[] opt = new int[max-9];


        for (int i = 1; i <= 4; i++) {
            opt[i] = 1;
        }
        for (int i = 5; i < max -9; i++) {
            opt[i] = Math.min(opt[i - 1], Math.min(opt[i - 2], Math.min(opt[i - 3], opt[i - 4]))) + 1;
        }
        for (int i = 0; i < target.length; i++) {
            if (target[i] < 10) {
                result[i] = -1;
            }else {
                result[i] = opt[target[i] - 10] + 4;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(new test1().minimumNumber(new int[]{16})));
    }
}
