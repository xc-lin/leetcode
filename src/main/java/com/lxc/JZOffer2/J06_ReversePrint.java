package com.lxc.JZOffer2;

import com.lxc.util.ListNode;

import java.util.Arrays;
import java.util.Stack;

public class J06_ReversePrint {
    // 用栈 很重要 先进后出
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int count=0;
        while (!stack.isEmpty()) {
            result[count++]=stack.pop();
        }
        return result;
    }

}
