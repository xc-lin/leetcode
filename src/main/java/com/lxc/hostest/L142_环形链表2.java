package com.lxc.hostest;

import com.lxc.util.ListNode;

public class L142_环形链表2 {
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode ptr = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }while(fast != slow);
        // f=2s f=s+nb s=nb 从head走a步可以到达入环点，slow走a步也可以到达入环点 那两个相遇的地方就是入环点
        while (ptr != slow) {
            // 两个都再走a步就可以在入口相遇
            ptr = ptr.next;
            slow = slow.next;
        }
        return slow;

    }
}
