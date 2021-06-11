package com.lxc.medium;

import com.lxc.util.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 1;
        int len2 = 1;
        ListNode tempL1 = l1;
        ListNode tempL2 = l2;

        while (tempL1.next != null) {
            len1++;
            tempL1 = tempL1.next;
        }
        while (tempL2.next != null) {
            len2++;
            tempL2 = tempL2.next;
        }
        if (len1 < len2) {
            int diff = len2 - len1;
            len1 = len2;
            while (diff > 0) {
                tempL1.next = new ListNode(0);
                tempL1 = tempL1.next;
                diff--;
            }
        } else {
            int diff = len1 - len2;
            len2 = len1;
            while (diff > 0) {
                tempL2.next = new ListNode(0);
                tempL2 = tempL2.next;
                diff--;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        boolean carry = false;
        for (int i = 0; i < len2; i++) {
            int num = l1.val + l2.val;
            if (carry) {
                num++;
                carry = false;
            }
            if (num > 9) {
                carry = true;
                num -= 10;
            }

            prev.next = new ListNode(num);
            prev = prev.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carry) {
            ListNode node = new ListNode(1);
            prev.next = node;
        }
        return head.next;
        /*StringBuffer num1 = new StringBuffer();
        StringBuffer num2 = new StringBuffer();
        while (l1 != null) {
            num1.insert(0, String.valueOf(l1.val));
            l1 = l1.next;
        }
        while (l2 != null) {
            num2.insert(0, String.valueOf(l2.val));
            l2 = l2.next;
        }
        int total = Integer.valueOf(num1.toString())+Integer.valueOf(num2.toString());

        ListNode prev = null;
        ListNode head = null;
        while (true){
            int singleNum = total%10;
            ListNode node=new ListNode(singleNum);
            if (head==null){
                head=node;
            }else {
                prev.next=node;
            }
            prev=node;

            if(total<10){
                return head;
            }
            total =total/10;
        }*/
    }
}


/**
 * [2,4,3]
 * [5,6,4]
 */