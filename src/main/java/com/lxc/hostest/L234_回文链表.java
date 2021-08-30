package com.lxc.hostest;

import com.lxc.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class L234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        int left=0;
        int right=list.size()-1;
        while (left<right){
            if (list.get(left)!=list.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if(head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode slow1=null;
        while (fast!=null&&fast.next!=null){
            slow1=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode next=null;
        if (fast==null){
            next=slow;
        }else {
            next=slow.next;
        }
        slow1.next=null;
        ListNode pre=null;
        ListNode curr=null;
        while (next!=null){
            curr=next;
            next=curr.next;
            curr.next=pre;
            pre=curr;
        }
        while (curr!=null&&head!=null){
            if (curr.val!=head.val){
                return false;
            }
            curr=curr.next;
            head=head.next;

        }
        return true;
    }
}
