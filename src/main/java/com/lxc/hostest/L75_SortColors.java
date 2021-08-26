package com.lxc.hostest;

public class L75_SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        // 要保证left指向的一定是0 或者1 不能是2
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==2){
                while (nums[i]==2&&i<right) {
                    int temp = nums[right];
                    nums[right] = nums[i];
                    nums[i] = temp;
                    right--;
                }
            } else if (nums[i]==0){
                int temp=nums[left];
                nums[left]=nums[i];
                nums[i]=temp;
                left++;
            }
            if (left>=right){
                break;
            }
        }
        
    }
}
