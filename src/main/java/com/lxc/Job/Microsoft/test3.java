package com.lxc.Job.Microsoft;

public class test3 {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int N = A.length;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++){
            nums[i]=Math.max(A[i],B[i]);
        }
        // 为什么要减1 的原因是 因为数组长度为N的数组中最大的连续数组元素是N 如果都存在那么缺失的值是N+1
        for (int i = 0; i < N; i++){
            while (nums[i]>0 && nums[i] < N && nums[i] != nums[nums[i]-1]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < N; i++){
            if(nums[i] - 1 != i){
                return i + 1;
            }
        }
        return N + 1;
    }
}
