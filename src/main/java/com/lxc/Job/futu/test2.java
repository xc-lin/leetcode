package com.lxc.Job.futu;

import com.lxc.util.ListNode;

public class test2 {
    public ListNode changeListNode (ListNode head, int pivot) {
        ListNode newTail =null;
        ListNode newHead=null;
        ListNode middle=null;
        if (head.val<pivot){
            newHead = new ListNode(head.val);
            middle=newHead;
        }else if (head.val>pivot){
            newTail = new ListNode(head.val);
        }else {
            middle=new ListNode(head.val);
        }

        head=head.next;
        while (head!=null){
            ListNode node=new ListNode(head.val);
            if (head.val<pivot){
                if (newHead==null){
                    newHead=node;
                    if (middle==null) {
                        middle = newHead;
                        middle.next = newTail;
                    }else {
                        newHead.next=middle;
                    }
                }else {
                    node.next=newHead;
                    newHead=node;
                }

            }else if (head.val>pivot){
                if (newTail==null){
                    newTail=node;
                }else {
                    node.next = newTail;
                    newTail = node;
                }
                middle.next=newTail;
            }else {
                node.next=newTail;
                middle.next=node;
                middle=node;

            }
            head=head.next;
        }
        return newHead;

    }
}
