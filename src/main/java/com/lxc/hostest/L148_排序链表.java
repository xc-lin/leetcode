package com.lxc.hostest;

import com.lxc.util.ListNode;


/**
 * 归并排序
 */
public class L148_排序链表 {
    public ListNode sortList(ListNode head) {
        if (head == null||head.next==null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        // 最后返回回来的只有一个
        head = sortList(head);
        head2 = sortList(head2);
        System.out.println(head.val);
        return merge(head,head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode result = new ListNode();
        ListNode node = result;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                node.next = new ListNode(head1.val);
                head1=head1.next;
            } else {
                node.next = new ListNode(head2.val);
                head2=head2.next;
            }
        }
        if (head1 != null) {
            node.next = head1;
        } else {
            node.next = head2;
        }
        return result.next;
    }
}
