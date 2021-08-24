package com.lxc.hostest;

import java.util.*;

public class L49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        // 考点：怎么构建hashmap的key
        for (int i = 0; i < strs.length; i++) {
            int count[] = new int[26];
            char c[] = strs[i].toCharArray();
            for (int j = 0; j < strs[i].length(); j++) {
                count[c[j] - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 26; j++) {
                if (count[j]!=0){
                    sb.append((char)('a'+j));
                    sb.append(count[j]+" ");
                }

            }
            String temp=sb.toString();
            if (!map.containsKey(temp)) {
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(temp, list);
                result.add(list);
            } else {
                map.get(temp).add(strs[i]);
            }
        }
        return result;

    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        // 考点：怎么构建hashmap的key
        for (int i = 0; i < strs.length; i++) {
            int count[] = new int[26];
            char c[] = strs[i].toCharArray();
            Arrays.sort(c);
            String temp=new String(c);
            if (!map.containsKey(temp)) {
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(temp, list);
                result.add(list);
            } else {
                map.get(temp).add(strs[i]);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
