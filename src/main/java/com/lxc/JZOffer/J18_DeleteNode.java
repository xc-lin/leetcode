package com.lxc.JZOffer;

import com.lxc.util.ListNode;

public class J18_DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node=head;
        ListNode prev=null;
        while(node!=null){
            if (node.val==val){
                if (node==head){
                    head=head.next;

                }else if(node.next==null){
                    prev.next=null;
                }else {
                    prev.next=node.next;
                }
            }
            prev=node;
            node=node.next;
        }
        return head;

    }
}
