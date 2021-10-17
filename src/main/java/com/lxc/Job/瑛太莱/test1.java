package com.lxc.Job.瑛太莱;

import com.lxc.util.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test1 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head==null){
            return null;
        }
        Deque<ListNode> stack = new LinkedList<>();
        ListNode node = head;
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;

        outer:
        while (node != null) {
            ListNode temp=node;
            for (int i = 0; i < k; i++) {
                if (node==null){
                    newTail.next=temp;
                    break outer;
                }
                stack.push(node);
                node = node.next;

            }

            while (!stack.isEmpty()) {
                newTail.next = new ListNode(stack.poll().val);
                newTail = newTail.next;
            }

        }
        return newHead.next;
    }

    public static void main(String[] args) {
//        ListNode newHead =reverseKGroup(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),10);
        ListNode newHead =reverseKGroup(new ListNode(1,new ListNode(2)),2);
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }


}
