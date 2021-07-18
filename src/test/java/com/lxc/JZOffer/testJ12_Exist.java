package com.lxc.JZOffer;

import org.junit.Test;

public class testJ12_Exist {

    @Test
    public void testExist() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board2 = {{'A'}};
        char[][] board3 = {{'A', 'A'}};
        char[][] board4 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new J12_Exist().exist(board4,  "ABCESEEE"));
    }

}