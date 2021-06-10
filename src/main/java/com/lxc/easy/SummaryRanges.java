package com.lxc.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        try {


            int low = nums[0];
            int high;

            for (int  i= 0; i < nums.length; i++) {

                if (i != 0 && nums[i] - nums[i-1] != 1) {
                    high = nums[i-1];
                    addToList(result, low, high);
                    low = nums[i];
                }
                if (i == nums.length - 1) {
                    high = nums[i];
                    addToList(result, low, high);
                    break;
                }

            }

        } catch (Exception e) {

        }
        return result;

    }

    public void addToList(List<String> result, int low, int high) {
        if (low != high) {
            result.add(String.format("%d->%d", low, high));
            return;
        }
        result.add(String.format("%d", low));
    }


    public List<String> summaryRangesBest(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }

}
