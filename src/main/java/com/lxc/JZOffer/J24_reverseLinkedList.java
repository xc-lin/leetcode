package com.lxc.JZOffer;

import com.lxc.util.ListNode;

public class J24_reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode next =null;
        ListNode prev= null;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        return prev;
    }
}
