package com.lxc.JZOffer2;

import org.apache.commons.lang.enums.Enum;

import java.util.ArrayList;
import java.util.List;

public class J57_2FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int []> result = new ArrayList<>();
        int temp = 0;
        int left = 1, right = 1;
        temp+=right;
        while (left <= target / 2) {

            if (temp>target){
                temp-=left;
                left++;

            }else if (temp<target){
                right++;
                temp+=right;
            }
            if(temp==target) {
                int singleResult[]=new int[right-left+1];
                for (int i = 0; i < singleResult.length; i++) {
                    singleResult[i]=i+left;
                }
                result.add(singleResult);
                right++;
                temp+=right;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public int[][] findContinuousSequence2(int target) {
        List<int[]> result = new ArrayList<>();
        int temp = 0;
        int left = 1, right = 1;
        temp=0;
        while (left <= target / 2) {

            if (temp > target) {
                temp -= left;
                left++;

            } else if (temp < target) {
                temp += right;
                right++;

            }
            if (temp == target) {
                int singleResult[] = new int[right - left ];
                for (int i = 0; i < singleResult.length; i++) {
                    singleResult[i] = i + left;
                }
                result.add(singleResult);
                temp += right;
                right++;

            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(new J57_2FindContinuousSequence().findContinuousSequence(9));
    }
}
