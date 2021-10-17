package com.lxc.Job.lilisi;

import java.util.*;

public class test2 {

    public ListNode sortList(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode temp = head;
        int total = 0;
        while (temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
            total++;
        }
        int size = map.size();
        ListNode newHead=new ListNode(0);
        ListNode node=newHead;
        int tempCount = 0;
        while (tempCount<total) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 0) {
                    list.add(entry.getKey());
                    map.put(entry.getKey(),entry.getValue()-1);
                }
            }
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            for (int i = 0; i < list.size(); i++) {
                tempCount++;
                node.next=new ListNode(list.get(i));
                node=node.next;
            }

        }
        return newHead.next;
    }
}
