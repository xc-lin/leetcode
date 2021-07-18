package com.lxc.JZOffer;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class J03_FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set= new HashSet<Integer>();
        for (int i : nums){
            if (!set.add(i)){
                return i;
            }
        }
        return 0;


    }
}
