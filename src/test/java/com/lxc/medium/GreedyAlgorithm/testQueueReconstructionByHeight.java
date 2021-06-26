package com.lxc.medium.GreedyAlgorithm;

import org.junit.Test;

import java.util.ArrayList;

public class testQueueReconstructionByHeight {
    @Test
    public void testReconstructQueue() {
        int result[][] = new QueueReconstructionByHeight().reconstructQueue(new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    @Test
    public void test() {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(0, 2);
        System.out.println(test);
    }

}