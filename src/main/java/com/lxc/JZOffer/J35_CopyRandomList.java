package com.lxc.JZOffer;

import com.lxc.util.ListNode;
import com.lxc.util.Node;

import java.util.HashMap;

public class J35_CopyRandomList {

    public Node copyRandomList(Node head) {
        Node node = head;
        if (node == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Node newNode = newHead;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, newHead);
        while (node.next != null) {
            node = node.next;
            newNode.next = new Node(node.val);
            newNode = newNode.next;
            map.put(node, newNode);
        }
        node = head;
        newNode = newHead;
        while (node != null) {

            newNode.random = map.get(node.random);
            node = node.next;
            newNode = newNode.next;
        }
        return newHead;
    }


}
