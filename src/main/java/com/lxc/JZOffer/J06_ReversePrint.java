package com.lxc.JZOffer;

import com.lxc.util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class J06_ReversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int result[]=new int[list.size()];
        int count=0;
        for (int i = list.size()-1; i >=0 ; i--) {
            result[count++]=list.get(i);
        }
        return result;
    }
    public int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int result[]=new int[stack.size()];
        int size=stack.size();
        for (int i = 0; i <size ; i++) {
            result[i]=stack.pop();
        }
        return result;
    }
}
