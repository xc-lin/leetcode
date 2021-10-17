package com.lxc.Job.用友;

public class test2 {
    int count=0;
    public int countWays (int num) {
        dfs(num);
        return count;
    }
    public boolean dfs(int left){
        if (left<0){
            return false;
        }
        if (left==0){
            count++;
            return false;
        }
        if (dfs(left-1)){
            if (dfs(left-2)){
                dfs(left-3);
            }
        }


        return true;
    }
}
