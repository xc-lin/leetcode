package com.lxc.hostest;

import java.security.PublicKey;

public class L215_数组中的第K个最大元素 {
    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        return quickSort(0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int left, int right, int k) {
        int index1 = Partition(left, right);
        if (k == index1) {
            return nums[k];
        }
        if (index1 < k) {
            return quickSort(index1 + 1, right, k);
        } else {
            return quickSort(left, index1 - 1, k);
        }

    }


    public int Partition(int left, int right) {
        int pri = nums[left];
        while (left < right) {

            while (left < right && nums[right] >= pri) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pri) {
                left++;
            }
            nums[right] = nums[left];

        }
        nums[left] = pri;
        return left;
    }



    public int findKthLargest2(int[] nums, int k) {
        int len=nums.length;
        buildMaxHeap(nums,len);
        for (int i = 0; i < k-1; i++) {
            nums[0]=nums[--len];
            headAdjust(nums,0,len);
        }
        return nums[0];
    }

    public  void buildMaxHeap(int[] nums,int len){
        for (int i = len/2; i >=0; i--) {
            headAdjust(nums,i,len);
        }
    }
    public void headAdjust(int[] nums, int index,int len){
        int temp=nums[index];
        for (int i = index*2+1; i < len; i=i*2+1) {

            if (i+1<len&&nums[i]<nums[i+1]){
                i++;
            }
            if (temp>=nums[i]){
                break;
            }else {
                int k=nums[index];
                nums[index]=nums[i];
                nums[i]=k;
                index=i;
            }
        }
        nums[index]=temp;
    }
    public static void main(String[] args) {
        System.out.println(new L215_数组中的第K个最大元素().findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
