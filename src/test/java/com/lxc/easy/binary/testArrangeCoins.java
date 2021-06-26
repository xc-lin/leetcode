package com.lxc.easy.binary;

import org.junit.Test;

public class testArrangeCoins {
    @Test
    public void testArrangeCoins() {
        System.out.println(new ArrangingCoins().arrangeCoins(8));
    }
    @Test
    public void testArrangeCoinsBest() {
        System.out.println(new ArrangingCoins().arrangeCoinsBest(1804289383));
    }
}
