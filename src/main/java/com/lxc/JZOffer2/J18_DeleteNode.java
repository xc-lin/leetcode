package com.lxc.JZOffer2;

import com.lxc.util.ListNode;

public class J18_DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            if (node.val == val) {
                if (node == head) {
                    head = head.next;
                    return head;
                }
                prev.next = node.next;
                return head;

            }
            prev = node;
            node=node.next;
        }
        return head;

    }
}
