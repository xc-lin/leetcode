package com.lxc.hostest;

import java.util.*;

public class L438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagramsBest(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] ps = p.toCharArray();
        char[] ss = s.toCharArray();
        int hs[] = new int[26];
        int hp[] = new int[26];
        for (int i = 0; i < ps.length; i++) {
            hp[ps[i] - 'a']++;
        }
        for (int i = 0; i < ps.length; i++) {
            hs[ss[i] - 'a']++;
        }
        if (Arrays.equals(hs, hp)) {
            result.add(0);
        }
        for (int i = 1; i <= ss.length - ps.length; i++) {
            hs[ss[i-1]-'a']--;
            hs[ss[i+ps.length-1]]++;
            if (Arrays.equals(hp,hs)){
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        char[] ps = p.toCharArray();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ps.length; i++) {
            map.put(ps[i], map.getOrDefault(ps[i], 0) + 1);
        }

        for (int i = 0; i < ss.length; i++) {
            if (!map.containsKey(ss[i])) {

                continue;
            }
            Map<Character, Integer> map2 = new HashMap<>(map);
            int tempI = i;
            int index = tempI;
            while (tempI < ss.length && map2.containsKey(ss[tempI])) {
                int num = map2.get(ss[tempI]);
                if (num == 1) {
                    map2.remove(ss[tempI]);
                } else {
                    map2.put(ss[tempI], num - 1);
                }
                tempI++;
            }
            if (map2.isEmpty()) {
                result.add(index);
            } else {
                // i=tempI-1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new L438_找到字符串中所有字母异位词().findAnagrams("abab", "ab"));
    }
}
