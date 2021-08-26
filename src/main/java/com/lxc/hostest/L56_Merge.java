package com.lxc.hostest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56_Merge {
    public int[][] merge(int[][] intervals) {
        List<int []> result=new ArrayList<>();
        int length1= intervals.length;
        int length2 = intervals[0].length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int i=0;
        while (i<length1){
            int left= intervals[i][0];
            int right = intervals[i][1];
            int index=0;
            for (int j = i; j < length1; j++) {
                if (intervals[j][0]>right){
                    break;
                }
                left=Math.min(left,intervals[j][0]);
                right=Math.max(right,intervals[j][1]);
                index=j;
            }
            result.add(new int[]{left,right});
            i=index+1;

        }
        return result.toArray(new int[result.size()][]);
    }

}
