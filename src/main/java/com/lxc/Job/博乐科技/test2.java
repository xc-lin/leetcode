package com.lxc.Job.博乐科技;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test2 {
    int[] arr;
    List<Integer> list=new LinkedList<>();
    int[] result;
    int count=0;
    public int[] printResult (int[] arr) {
        this.arr=arr;
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        this.result=new int[arr.length];
        recur(0,arr.length-1);
        return result;
    }

    public void recur(int left ,int right){
        if (left>right){
            return;
        }
        result[count++]=arr[right];
        list.remove((Object)arr[right]);
        int index=right;
        Deque<Integer> deque=new LinkedList<>();
        deque.add(arr[right]);
        while (!list.isEmpty()&&!list.isEmpty()) {
            int root= deque.poll();
            index=list.size()-1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) >= root) {
                    index = i;
                    break;
                }
            }
            if (index-1>=0) {
                result[count++] = list.get(index - 1);
                deque.add(arr[index - 1]);
            }
            result[count++]=list.get(list.size()-1);
            deque.add(arr[right-1]);
            if (index-1>=0) {
                list.remove(index - 1);
            }
            list.remove(list.size()-1);
        }
//        recur(left,index-1);
//        recur(index,right-1);
    }

    public static void main(String[] args) {
        new test2().printResult(new int[]{1,4,3,9,20,10,5});
    }

}
