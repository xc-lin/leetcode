package com.lxc.hostest;

public class L55_CanJump {

    public boolean canJump(int[] nums) {
        boolean opt[] = new boolean[nums.length];
        opt[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (opt[i]) {
                for (int j = 1; j <=nums[i]; j++) {
                    int temp=i+j;
                    if (temp>=nums.length-1){
                        return true;
                    }
                    if (temp<nums.length){
                        opt[temp]=true;
                    }
                }

            }

        }
        return opt[nums.length-1];
    }

    public boolean canJump2(int[] nums) {
        int rightMost=0;
        for (int i = 0; i < nums.length; i++) {
            if (i<=rightMost){
                int temp=i+ nums[i];
                if (temp>=nums.length-1){
                    return true;
                }
                rightMost=Math.max(rightMost,temp);
            }

        }
        return false;
    }
}
