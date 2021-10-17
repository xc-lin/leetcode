package com.lxc.Job.lilisi;


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class test1 {
    public ListNode formatList(ListNode head) {
        ListNode newHead = null;
        ListNode tail = null;
        boolean insertTail=true;
        while (head != null) {
            if (newHead == null) {
                tail = new ListNode(head.val);
                newHead=tail;
            }else {
                if (insertTail){
                    insertTail=false;
                    tail.next=new ListNode(head.val);
                    tail=tail.next;
                }else {
                    insertTail=true;
                    ListNode node=new ListNode(head.val);
                    node.next=newHead;
                    newHead=node;
                }
            }
            head=head.next;
        }
        return newHead;
    }
}
