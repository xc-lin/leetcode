package com.lxc.JZOffer;

import com.lxc.util.ListNode;

import java.util.HashSet;
import java.util.List;

public class J52_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA !=nodeB) {
            if (nodeA==null){
                nodeB=headB.next;
                headB=nodeB;
                nodeA=headA;
                continue;
            }
            if (nodeB==null){
                nodeA=headA.next;
                headA=nodeA;
                nodeB=headB;
                continue;
            }
            nodeA=nodeA.next;
            nodeB=nodeB.next;
        }
        return nodeA;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        HashSet<ListNode> hashSet =  new HashSet<>();
        while (nodeA!=null) {
           hashSet.add(nodeA);
           nodeA=nodeA.next;
        }
        while (nodeB!=null) {
            if(hashSet.contains(nodeB)){
                return nodeB;
            }
            nodeB=nodeB.next;

        }

        return null;
    }
}
