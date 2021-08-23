package com.lxc.JZOffer2;

import com.lxc.util.ListNode;

public class J52_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        ListNode result = null;

        while (nodeA != nodeB && headA != null && headB != null) {
            nodeA = headA;
            nodeB = headB;
            while (nodeA != null && nodeB != null) {
                if (nodeA == nodeB) {
                    result = nodeA;
                    break;
                }
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            if (nodeA == null) {
                headB = headB.next;
            }
            if (nodeB == null) {
                headA = headA.next;
            }
        }
        return result;

    }

    public ListNode getIntersectionNodeBest(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        // 当两个node不相交的时候 最后nodeA在尾节点 nodeB在尾节点
        // 他们不为空 nodeA nodeB分别指向下一个节点
        // 他们同时为空 即跳出循环
        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            }else {
                nodeA=nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;
            }else {
                nodeB = nodeB.next;
            }
        }
        return nodeA;

    }

}
