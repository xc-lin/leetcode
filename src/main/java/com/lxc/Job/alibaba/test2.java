package com.lxc.Job.alibaba;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Deque<Integer> stack =new LinkedList<>();
        int result =0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i]>stack.peek()){
                stack.pop();
                if (stack.isEmpty()){
                    result+=nums[i];
                    break;
                }
                int min = Math.min(stack.peek(),nums[i]);
                result+=min;
            }
            stack.push(nums[i]);
        }
        while (stack.size()>1){
            stack.pop();
            result+=stack.peek();
        }
        System.out.println(result);
    }
}
