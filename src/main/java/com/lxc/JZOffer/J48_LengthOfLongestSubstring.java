package com.lxc.JZOffer;

import java.util.HashMap;

public class J48_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 用hashmap来存储每一个字符出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int[] opt = new int[s.length()];
        // 初始化第一个，一个的子串一定是一个
        opt[0] = 1;
        // 放进hashmap中
        map.put(s.charAt(0), 0);
        // 遍历除了第一个意外的所有字符
        for (int i = 1; i < s.length(); i++) {
            // 如果map中没有这个字符就说明，这个字符还没出现过
            // 因此就是前面的字串长度+自己也就是+1
            if (!map.containsKey(s.charAt(i))) {
                opt[i] = opt[i - 1] + 1;
            } else {
                // 得到这个字符上一次出现的位置
                int preIndex = map.get(s.charAt(i));
                // 如果这个字符出现的位置大于以上一个字符结尾的最大字串长度，这个字符在我字串之外，因此我不用管这个重复的字符
                // 和上面的处理方式相同，直接+1即可
                if (i - preIndex > opt[i - 1]) {
                    opt[i] = opt[i - 1] + 1;
                } else {
                    // 如果这个字符出现的位置和在字串的开头或之中那么我们最长字串的位置就是从这个重复字符开始到结尾
                    // 就是这个点减去重复字符的位置
                    opt[i] = i - preIndex;
                }
            }
            // 更新最近的字符出现位置
            // 如果没有出现过也放进hashmap中
            map.put(s.charAt(i), i);
        }
        int max = opt[0];
        for (int i = 1; i < opt.length; i++) {
            if (max < opt[i]) {
                max = opt[i];
            }
        }
        return max;

    }
    public int lengthOfLongestSubstringBest(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 用hashmap来存储每一个字符出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        int pre=0;
        // 遍历除了第一个意外的所有字符
        for (int i = 0; i < s.length(); i++) {

            // 如果map中没有这个字符就说明，这个字符还没出现过
            // 因此就是前面的字串长度+自己也就是+1
            if (!map.containsKey(s.charAt(i))) {
                pre = pre + 1;
            } else {
                // 得到这个字符上一次出现的位置
                int preIndex = map.get(s.charAt(i));
                // 如果这个字符出现的位置大于以上一个字符结尾的最大字串长度，这个字符在我字串之外，因此我不用管这个重复的字符
                // 和上面的处理方式相同，直接+1即可
                if (i - preIndex > pre) {
                    pre = pre + 1;
                } else {
                    // 如果这个字符出现的位置和在字串的开头或之中那么我们最长字串的位置就是从这个重复字符开始到结尾
                    // 就是这个点减去重复字符的位置
                    pre = i - preIndex;
                }
            }
            // 更新最近的字符出现位置
            // 如果没有出现过也放进hashmap中
            map.put(s.charAt(i), i);
            max=Math.max(max,pre);
        }

        return max;

    }
    public int lengthOfLongestSubstringWrong(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] opt = new int[s.length()];
        opt[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < opt[i - 1]; j++) {
                if (s.charAt(i - 1 - j) == s.charAt(i)) {
                    opt[i] = 1;
                    break;
                }
            }
            if (opt[i] == 0) {
                opt[i] = ++opt[i - 1];
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


}
