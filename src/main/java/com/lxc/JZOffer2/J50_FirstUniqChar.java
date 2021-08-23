package com.lxc.JZOffer2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class J50_FirstUniqChar {
    public char firstUniqChar(String s) {
        char c[]=s.toCharArray();
        HashMap<Character,Integer> map = new HashMap();
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])){
                map.put(c[i],-1);
            }else {
                map.put(c[i],i);
            }
        }
        int index=Integer.MAX_VALUE;
        for (char temp:c){
            if (map.get(temp)!=-1){
                return temp;
            }
        }
        return ' ';
    }
}
