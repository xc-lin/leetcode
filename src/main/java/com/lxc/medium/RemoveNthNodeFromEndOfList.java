package com.lxc.medium;

import com.lxc.util.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            length++;
        }
        int targetNodeIndex = length - n;
        int count = 0;
        curr = head;
        prev = null;
        while (curr != null) {
            if (count == targetNodeIndex) {
                if (prev==null){
                    head= head.next;
                    break;
                }
                prev.next=curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
            count++;

        }
        return head;
    }
}
