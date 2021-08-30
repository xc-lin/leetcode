package com.lxc.hostest;

import com.lxc.util.ListNode;

public class L160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            // 等于往前走了一步
            if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }
            // 等于往前走了一步
            if (nodeB == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }


        }
        return nodeA;
    }


}
