package com.lxc.JZOffer2;

import com.lxc.util.Node;

import java.util.HashMap;

public class J35_CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node oldHead = head;
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node node = newHead;
        map.put(head, node);
        while (head.next != null) {
            node.next = new Node(head.next.val);
            node = node.next;
            head = head.next;
            // 建立原节点到新节点的映射
            map.put(head, node);

        }
        node=newHead;
        head=oldHead;
        while (head != null) {
            if (head.random!=null) {
                node.random=map.get(head.random);
            }
            node = node.next;
            head = head.next;
        }
        return newHead;
    }
}
