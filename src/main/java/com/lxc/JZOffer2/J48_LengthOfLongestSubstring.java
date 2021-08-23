package com.lxc.JZOffer2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class J48_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int opt[] = new int[length];
        opt[0] = 1;
        char c[] = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put(c[0],0);
        for (int i = 1; i < length; i++) {
            if (map.containsKey(c[i])&&(i-map.get(c[i]))<=opt[i-1]) {
                opt[i]=i-map.get(c[i]);
                map.put(c[i],i);
            } else {
                opt[i] = opt[i - 1] + 1;
                map.put(c[i],i);
            }
        }
        int max = opt[0];
        for (int i = 1; i < opt.length; i++) {
            if (max < opt[i]) {
                max = opt[i];
            }
        }
        return max;


    }

    public static void main(String[] args) {
        System.out.println(new J48_LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
    }
}
