package com.lxc.easy;

import org.junit.Test;

import java.util.Arrays;

public class testTwoSum {
    @Test
    public void testTwoSumForce() {
        TwoSum twoSum=  new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSumForce(new int[]{2, 7, 11, 15}, 9)));
    }

    @Test
    public void testTwoSumBinary() {
        TwoSum twoSum=  new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSumBinary(new int[]{2, 7, 11, 15}, 9)));
    }

    @Test
    public void testTwoSumBest() {
        TwoSum twoSum=  new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSumBest(new int[]{2, 7, 11, 15}, 9)));
    }


}
