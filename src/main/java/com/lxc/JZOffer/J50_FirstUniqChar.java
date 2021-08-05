package com.lxc.JZOffer;

import sun.jvm.hotspot.utilities.HashtableEntry;

import java.util.*;

public class J50_FirstUniqChar {
    // 通过在map的value属性（数组下标）来判断谁是第一个
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        Map.Entry<Character, Integer> entryResult = null;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1 && (entryResult == null || entry.getValue() < entryResult.getValue())) {
                entryResult = entry;
            }
        }
        if (entryResult == null) {
            return ' ';
        }
        return entryResult.getKey();

    }

    // 通过重新遍历string中的字符判断第一个是谁
    public char firstUniqChar2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != -1) {
                return s.charAt(i);
            }
        }
        return ' ';

    }


    //
    public char firstUniqChar3(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                return entry.getKey();
            }
        }
        return ' ';

    }
}
