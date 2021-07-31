package com.lxc.JZOffer;

public class J21_Exchange {
    public int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right){

            if (nums[left]%2==0&&nums[right]%2!=0){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
            if (nums[left]%2!=0){
                left++;
            }
            if (nums[right]%2==0){
                right--;
            }
        }
        return nums;

    }

    public int[] exchangeBest(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            if ((nums[left]&1)==1){
                left++;
                continue;
            }
            if ((nums[right]&1)==0){
                right--;
                continue;
            }
            if (left<right){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }

        }
        return nums;

    }
}
