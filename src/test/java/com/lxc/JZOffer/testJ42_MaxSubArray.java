package com.lxc.JZOffer;

import org.junit.Test;

public class testJ42_MaxSubArray {
    @Test
    public void testMaxSubArray(){
        System.out.println(new J42_MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    @Test
    public void testMaxSubArrayBest(){
        System.out.println(new J42_MaxSubArray().maxSubArrayBest(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
