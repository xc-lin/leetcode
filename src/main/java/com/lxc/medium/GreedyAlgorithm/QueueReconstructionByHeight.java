package com.lxc.medium.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        ArrayList<int[]> result = new ArrayList<int[]>();
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] >= result.size()) {
                result.add(people[i]);
            } else {
                result.add(people[i][1], people[i]);
            }


        }

        return result.toArray(new int[result.size()][]);
    }
}
