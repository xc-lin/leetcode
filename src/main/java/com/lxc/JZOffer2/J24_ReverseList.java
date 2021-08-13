package com.lxc.JZOffer2;

import com.lxc.util.ListNode;

import java.util.List;
import java.util.Stack;

public class J24_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode node = newHead;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return newHead;
    }

    ListNode result = null;

    public ListNode reverseListBest(ListNode head) {
        recur(head);
        return result;
    }

    public ListNode recur(ListNode head) {
        if (head == null || head.next == null) {
            result = head;
            return head;
        }
        ListNode node = reverseList(head.next);
        node.next = head;
        head.next = null;
        return head;
    }

    public ListNode reverseListTraverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (next!=null){
            curr.next=pre;
            pre=curr;
            curr=next;
            next=next.next;
        }
        curr.next=pre;
        return curr;
    }

}
