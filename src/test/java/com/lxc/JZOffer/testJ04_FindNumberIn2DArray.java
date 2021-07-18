package com.lxc.JZOffer;

import org.junit.Test;

public class testJ04_FindNumberIn2DArray {
    @Test
    public void testFindNumberIn2DArray(){
        int[][] board = {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22},{10, 13, 14, 17, 24}};
        int[][] board2 = {{}};
        System.out.println(new J04_FindNumberIn2DArray().findNumberIn2DArray(board2,5));
    }
}
