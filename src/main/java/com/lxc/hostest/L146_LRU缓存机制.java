package com.lxc.hostest;

import java.util.*;

public class L146_LRU缓存机制 {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map;
    int capacity;
    int used = 0;
    Node head;
    Node tail;

    public L146_LRU缓存机制(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre = head;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;

            head = node;
            return map.get(key).value;
        }
        System.out.println(map.toString());
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (map.containsKey(key)) {

            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.value = value;
            node.pre = head;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            map.remove(key);

        } else if (used < capacity) {
            // node不存在于map中 直接插入在链表头部
            node = new Node(key, value);
            node.pre = head;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            used++;
        } else if (used >= capacity) {
            // lru
            tail.pre.pre.next = tail;
            tail.pre = tail.pre.pre;

            node = new Node(key, value);
            node.pre = head;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
        }
        map.put(key, node);

    }
}
