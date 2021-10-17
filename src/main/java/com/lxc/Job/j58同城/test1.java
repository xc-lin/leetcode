package com.lxc.Job.j58同城;

public class test1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 写出返回最小砝码所需数量的实现代码
     * @param weights int整型一维数组 输入任意砝码数组
     * @param total int整型 目标值
     * @return int整型
     */
    int[] weights;
    int total,result=Integer.MAX_VALUE;
    public int weight2 (int[] weights, int total) {
        // write code here
        this.weights=weights;
        this.total=total;
        dfs(0,0,0);
        return result==Integer.MAX_VALUE?-1:result;

    }

    public void dfs(int index,int num,int sum){
        if (sum==total){
            if (num<result){
                result=num;
            }
            return;
        }
        if (sum>total){
            return;
        }
        for (int i = 0; i < weights.length; i++) {
            dfs(i+1,num+1,sum+weights[i]);
        }
    }

//    public int weight (int[] weights, int total) {
//        int opt[]=new int[weights.length];
//        if (total%weights[0]==0){
//            opt[0]=total/weights[0];
//        }else {
//            opt[0]=-1;
//        }
//        for (int i = 1; i < weights.length;i++) {
//            for (int j = 0; j <=i; j++) {
//                if (opt[i]!=-1){
//
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new test1().weight2(new int[]{1,2,5},11));
    }
}
