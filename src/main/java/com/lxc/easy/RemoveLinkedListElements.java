package com.lxc.easy;

import com.lxc.util.ListNode;

import java.util.List;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = new ListNode();
        ListNode prev = new ListNode();
        curr = head;
        while (curr != null) {
            if (curr.val == val) {
                if (curr == head) {
                    head = head.next;
                    curr = head;
                } else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
                continue;

            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
