package com.lxc.hostest;

public class L4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int i = 0;
        int j = 0;
        int totalLength = length1 + length2;
        int mid = 0, count = 0;
        boolean even = false;
        if (totalLength % 2 == 0) {
            even = true;
            mid = totalLength / 2 + 1;
        } else {
            mid = (totalLength + 1) / 2;
        }
        int pre = Integer.MIN_VALUE;
        int curr = 0;
        while (i < length1 && j < length2 && count != mid) {
            pre = curr;
            count++;
            if (nums1[i] < nums2[j]) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
        }
        if (count != mid && i < length1) {
            pre = curr;
            count++;
            curr = nums1[i];
            i++;
        }
        while (count != mid && j < length2) {
            pre = curr;
            count++;
            curr = nums2[j];
            j++;
        }
        while (even) {
            return (curr + pre) / 2.0;
        }
        return curr;
    }
}
