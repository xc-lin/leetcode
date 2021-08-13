package com.lxc.JZOffer2;

import com.lxc.util.ListNode;

public class J25_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode head = node;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
                continue;
            }
            if (l1.val < l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
                continue;
            }
        }
        if (l1 != null) {
            node.next = l1;
        }else {
            node.next = l2;
        }
        return head.next;

    }
}
