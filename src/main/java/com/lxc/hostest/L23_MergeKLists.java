package com.lxc.hostest;

import com.lxc.util.ListNode;

import java.util.List;

public class L23_MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return new ListNode();
        }
        int length=lists.length;
        int index=0;

        while (length>1){
            int count=0;
            for (int j = 0; j < length/2; j++) {
                lists[j]=mergeTwoLists(lists[index++],lists[index++]);
                count++;
            }
            if (length%2!=0){
                lists[length/2+1]=lists[length-1];
                count++;
            }
            length=count;

        }
        return lists[0];

    }
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        ListNode newHead = new ListNode();
        ListNode node=newHead;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                node.next=new ListNode(list1.val);
                node=node.next;
                list1=list1.next;
            }else {
                node.next=new ListNode(list2.val);
                node=node.next;
                list2=list2.next;
            }
        }
        if (list1!=null){
            node.next=list1;
        }else {
            node.next=list2;
        }
        return newHead.next;
    }
}
