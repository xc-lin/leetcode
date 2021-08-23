package com.lxc.hostest;

import java.util.HashMap;
import java.util.Map;

public class L3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        char c[] = s.toCharArray();
        int length = c.length;
        int opt[] = new int[length];
        opt[0]=1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(c[0], 0);
        int result=1;
        for (int i = 1; i < length; i++) {
            if (map.containsKey(c[i]) && map.get(c[i]) >= i - opt[i - 1]) {
                opt[i] = i - map.get(c[i]);
                map.put(c[i], i);

            } else {
                map.put(c[i], i);
                opt[i] = opt[i - 1] + 1;
            }
            result=Math.max(opt[i],result);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new L3_lengthOfLongestSubstring().lengthOfLongestSubstring("bbtablud"));
    }

}
