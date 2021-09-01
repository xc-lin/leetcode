package com.lxc.hostest;

public class L338_比特位计数 {
    public int[] countBits(int n) {
        int[] result= new int[n+1];
        for (int i = 0; i <=n; i++) {
            int count=0;
            int temp=i;
            for (int j = 0; j < 32; j++) {
                if ((temp&1)==1){
                    count++;
                }
                temp>>=1;
            }
            result[i]=count;
        }
        return result;
    }

    public int[] countBits2(int n) {
        int[] result= new int[n+1];
        for (int i = 0; i <=n; i++) {
            int count=0;
            int temp=i;
            while (temp>0){
                count++;
                temp=temp&(temp-1);
            }
            result[i]=count;
        }
        return result;
    }

    public int[] countBits3(int n) {
        int[] result= new int[n+1];
        for (int i = 1; i <=n; i++) {
            // i>>1 好理解      等于/2
            result[i]=result[i>>1]+(i&1);
        }
        return result;
    }

    public static void main(String[] args) {
        new L338_比特位计数().countBits3(5);
    }

}
