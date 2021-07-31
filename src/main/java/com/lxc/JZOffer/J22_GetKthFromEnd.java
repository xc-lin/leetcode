package com.lxc.JZOffer;

import com.lxc.util.ListNode;

public class J22_GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node= head;
        int sum=0;
        while (node!=null){
            sum++;
            node=node.next;
        }
        for (int i = 0; i < sum-k; i++) {
            head=head.next;
        }
        return head;
    }

    public ListNode getKthFromEndBest(ListNode head, int k) {
        ListNode node= head;
        for (int i = 0; i < k; i++) {
            node=node.next;
        }
        while (node!=null){
            node=node.next;
            head=head.next;
        }
        return head;
    }
}
