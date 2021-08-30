package com.lxc.hostest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length=s.length();
        Set<String> set=new HashSet<>(wordDict);
        // opt[i]代表s的前i个是否能被wordDict表示。从1开始
        boolean opt[]=new boolean[length+1];
        // 代表空字符串可以被wordDict表示
        opt[0]=true;
        for (int i = 1; i < length+1; i++) {
            for (int j = 0; j < i; j++) {
                // 判断前i个能否被wordDict表示，查看前j个能否被成功表示，如果前j个可以被成功表示，那么看[j+1,i]个在wordDict中是否存在
                // opt中 从1开始 ，所以j+1在s中就是j，i是从第一个开始计数的第i个，因为subString的右区间是开区间所以直接是i
                if (opt[j]&&set.contains(s.substring(j,i))){
                    opt[i]=true;
                }
            }
        }
        return opt[length];
    }
}
