package com.lxc.Sort;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int []nums,int low ,int high){
        if (low < high) {
            int pivotpos=Partition(nums,low ,high);
            quickSort(nums,low,pivotpos-1);
            quickSort(nums, pivotpos+1,high);
        }
    }

    public int Partition (int []nums,int low ,int high){
        int pivot=nums[low];
        while (low<high){
            while (low<high&& nums[high]>=pivot){
                high--;
            }
            nums[low]=nums[high];
            while (low<high&& nums[low]<=pivot){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=pivot;
        return low;
    }

    public static void main(String[] args) {
        int nums[]=new int[]{27,38,13,49,76,97,65,49};
        new QuickSort().quickSort(nums,0, 7);
        System.out.println(Arrays.toString(nums));
    }
}
