package com.lxc.hostest;

import com.lxc.util.ListNode;

public class L21_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode node = newHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;
            }else{
                node.next = new ListNode(l2.val);
                node = node.next;
                l2 = l2.next;
            }
        }
        while (l1!=null){
            node.next=new ListNode(l1.val);
            node = node.next;
            l1 = l1.next;
        }
        while (l2!=null){
            node.next=new ListNode(l2.val);
            node = node.next;
            l2 = l2.next;
        }
        return newHead;

    }
}
