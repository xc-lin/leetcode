package com.lxc.Tencent;

import com.lxc.util.ListNode;

import java.util.HashMap;
import java.util.Map;

//5,{0,1,3,4,5,11,6}
public class test1 {
    public ListNode[] solve(int m, ListNode a) {
        // write code here
        ListNode result[] = new ListNode[m];
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode head = a;
        while (head != null) {
            if (map.containsKey(head.val%m)){
                ListNode temp=map.get(head.val%m);
                ListNode node=new ListNode(head.val);
                temp.next=node;
                map.put(head.val%m,node);
            }else {
                ListNode node=new ListNode(head.val);
                result[head.val%m]=node;
                map.put(head.val%m,node);
            }
            head=head.next;
        }
        return result;

    }
}
