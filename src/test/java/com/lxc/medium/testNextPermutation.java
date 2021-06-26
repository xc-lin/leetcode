package com.lxc.medium;

import org.junit.Test;

import java.util.Arrays;

public class testNextPermutation {
    @Test
    public void testNextPermutation(){
        int []a= {3,2,1};
        new NextPermutation().nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
