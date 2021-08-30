package com.lxc.hostest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class L169_多数元素 {
    public int majorityElement(int[] nums) {
        int vote=1;
        int num=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (vote==0){
                vote++;
                num=nums[i];
            }else if (num!=nums[i]){
                vote--;
            }else {
                vote++;
            }
        }
        return num;
    }
}
