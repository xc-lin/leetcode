package com.lxc.easy.binary;

public class ArrangingCoins {

    int arrangeCoins(int n) {
        int count = 0;
        while (n >= 0) {
            count++;
            n -= count;

        }
        return --count;
    }

    int arrangeCoinsBest(long n) {
        long low = 1;
        long high = n;
        long mid = 0;
        int result=0;
        while (low <= high) {
            mid=(high+low)/2;
            if((1+mid)*mid/2>n){
                high=mid-1;
            }else {
                result=(int)mid;
                low=mid+1;
            }
        }
        return result;
    }
}
