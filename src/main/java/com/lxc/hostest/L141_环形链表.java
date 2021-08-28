package com.lxc.hostest;

import com.lxc.util.ListNode;
import com.lxc.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class L141_环形链表 {
    public boolean hasCycleBest(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        Map<ListNode, Character> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, 'a');
            head = head.next;
        }
        return false;
    }
}
