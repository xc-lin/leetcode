package com.lxc.easy;

import com.lxc.util.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = null;
        ListNode newNode = null;
        while (head != null) {
            newNode = new ListNode(head.val, curr);
            curr = newNode;
            head = head.next;

        }
        return curr;
    }
}
