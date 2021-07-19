package com.lxc.JZOffer;

public class J11_MinArray {
    public int minArray(int[] numbers) {
        int low=0;
        int high=numbers.length-1;;
        int mid=0;
        while(low<high){
            mid=(low+high)/2;
            if (numbers[mid]>numbers[high]){
                low=mid+1;
            }else if(numbers[mid]<numbers[high]) {
                high = mid ;
            }else {
                high--;
            }
        }
        return numbers[low];
    }
}
