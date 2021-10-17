package com.lxc.Job.博乐科技;

import sun.jvm.hotspot.memory.PlaceholderEntry;

import java.util.Arrays;

public class test3 {
    int[] tempArray;

    public int[] mergeSort(int[] nums, int k) {
        tempArray = new int[nums.length];
        mergeSort2(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    void mergeSort2(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort2(nums, left, mid);
            mergeSort2(nums, mid + 1, right);
            merge(nums, left, right, mid);
        }
    }

    void merge(int[] A, int low, int high, int mid) {
        int right = mid+1;
        int[] tempArray = new int[A.length];
        for (int i = low; i <= high; i++) {
            tempArray[i] = A[i];
        }
        int tempPos = low;
        while (low <= mid && right <= high) {
            if (tempArray[low] > tempArray[right]) {
                A[tempPos++] = tempArray[low++];
            } else {
                A[tempPos++] = tempArray[right++];
            }
        }

        while (low <= mid) {
            A[tempPos++] = tempArray[low++];
        }
        while (right <= high) {
            A[tempPos++] = tempArray[right++];
        }
    }

    public static void main(String[] args) {
        new test3().mergeSort(new int[]{3, 5, 2, 6, 1, 7, 4}, 3);
    }
}
