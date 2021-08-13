package com.lxc.JZOffer2;

public class J11_MinArray {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int compareIndex=numbers.length - 1;
        while (left <= right&&compareIndex>=0) {
            int compareValue = numbers[compareIndex];
            int mid = (left + right) / 2;
            if (numbers[mid] < compareValue) {
                right = mid - 1;
            }
            if (numbers[mid] > compareValue) {
                left = mid + 1;
            }
            if (numbers[mid] == compareValue){
                compareIndex--;
                right=Math.min(right,compareIndex);
            }
        }
        return numbers[left];
    }

    public int minArrayBetter(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 可以直接和right比 因为这个值如果比最右边的小也一定比他左边的递减小
            // right边界只有在mid值更小的时候才会变
            if (numbers[mid] < numbers[right]) {
                right = mid;
                continue;
            }
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
                continue;
            }
            if (numbers[mid] == numbers[right]){
                right--;
            }
        }
        return numbers[left];
    }
}