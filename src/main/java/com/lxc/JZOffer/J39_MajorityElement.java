package com.lxc.JZOffer;

import java.util.HashMap;
import java.util.Map;

public class J39_MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int a = map.get(num);
                map.put(num, ++a);
            } else {
                map.put(num, 1);
            }


        }
        int k = 0;
        int result = 0;
        for (int a : map.keySet()) {
            if (result < map.get(a)) {
                result = map.get(a);
                k = a;
            }
        }
        return k;
    }

    public int majorityElementBest(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Map.Entry<Integer, Integer> result=null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (result==null||entry.getValue()>result.getValue()){
                result=entry;
            }
        }
        return result.getKey();
    }
}
