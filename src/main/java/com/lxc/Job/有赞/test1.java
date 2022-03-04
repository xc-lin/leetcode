package com.lxc.Job.有赞;

public class test1 {
    public static long numTrees (int n, int h) throws Exception {
        return dfs(n,h);
    }
    public static long dfs(int n,int h){
        if (n==1){
            if (h==0){
                return 0;
            }
            return 1;
        }
        if (n==0){
            return 1;
        }
        long temp = 0;

        for (int i = 0; i < (n)/2; i++) {
            temp+=dfs(i,h-1)*dfs(n-1-i,h-1);
        }
        long l = 0;
        if (n %2!=0){
            l = dfs(n/2,h-1)*dfs(n/2,h-1);
        }
        return temp*2+l;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(numTrees(20, 20));
    }
}
