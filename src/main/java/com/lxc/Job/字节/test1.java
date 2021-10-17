package com.lxc.Job.字节;

public class test1 {

    public static int eggNum(int k){
        int[][] opt=new int[k+1][3];
        opt[0][0]=0;
        for (int i = 0; i <3 ; i++) {
            opt[0][i]=0;
        }

        for (int i = 0; i < k+1; i++) {
            opt[i][1]=i;
        }

        for (int i = 1; i < k+1; i++) {
            int min=Integer.MAX_VALUE;
            // 在一共有i层的情况下，在第j层扔鸡蛋会需要多少次 取最少的
            for (int j = 1; j <= i; j++) {
                // opt[i-j][2] 如果在第j层扔了一次鸡蛋，没碎，那么需要在i-j ～ i层 继续扔，
                // opt[j-1][1] 如果在第j层扔了一次鸡蛋，碎了，那么需要再扔 j-1次
                min=Math.min(Math.max(opt[i-j][2],opt[j-1][1]),min);
            }
            opt[i][2]=min+1;
        }
        return opt[k][2];
    }

    public static void main(String[] args) {
        eggNum(10);
    }
}
