package com.lxc.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSumBest(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int item = target - nums[i];
            if(map.containsKey(item)){
                return new int[]{map.get(item),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public int[] twoSumForce(int[] nums, int target) {
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }


    public int[] twoSumBinary(int[] nums, int target) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        Collections.sort(numList);
        int result[] = new int[2];
        for (int i = 0; i < numList.size(); i++) {
            int item = target - numList.get(i);
            int low = 0;
            int high = numList.size() - 1;
            while (low <= high) {
                int mid = (high + low) / 2;
                if (numList.get(mid) == item) {
                    boolean first = false;
                    for (int j = 0; j < nums.length; j++) {

                        if (nums[j] == numList.get(i) && !first) {
                            first = true;
                            result[0] = j;
                        } else if (nums[j] == numList.get(mid)) {
                            result[1] = j;
                        }
                    }
                    return result;
                }
                if (numList.get(mid) > item) {
                    high = mid - 1;
                }
                if (numList.get(mid) < item) {
                    low = mid + 1;
                }
            }

        }
        return null;
    }
}
