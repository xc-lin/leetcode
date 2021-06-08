package com.lxc.easy;

import org.junit.Test;

public class testReverseInteger {
    @Test
    public void testReverseBest(){
        ReverseInteger reverseInteger= new ReverseInteger();
        System.out.println(reverseInteger.reverseBest(-188));
    }
    @Test
    public void testreverseByString(){
        ReverseInteger reverseInteger= new ReverseInteger();
        System.out.println(reverseInteger.reverseByString(-188));
    }

}
