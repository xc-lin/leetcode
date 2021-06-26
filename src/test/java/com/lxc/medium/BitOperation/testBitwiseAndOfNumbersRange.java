package com.lxc.medium.BitOperation;

import org.junit.Test;

public class testBitwiseAndOfNumbersRange {
    @Test
    public void testRangeBitwiseAnd(){
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(1,2147483647));
    }
    @Test
    public void testRangeBitwiseAndBest(){
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAndBest(1,2147483647));
    }
    @Test
    public void testRangeBitwiseAnd2(){
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd2(5,7));
    }
}
