package com.lxc.Job.奇安信;

public class test1 {
    public static int DoPermute (int M, int N) {
        int tempM=M+N-2;
        int pos=0;
        for (int i = 2; i <= N; i++) {
            pos=(pos+tempM)%i;
            tempM--;
        }

        return pos+1;
    }

    public static void main(String[] args) {
        System.out.println(DoPermute(3,5));
    }
}
