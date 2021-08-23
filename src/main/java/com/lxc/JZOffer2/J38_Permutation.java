package com.lxc.JZOffer2;

import javax.security.auth.callback.CallbackHandler;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class J38_Permutation {
    // 这个是string的char数组
    char[] chars;
    // 这个是result
    List<String> list = new LinkedList<>();
    // 这个是每一段string的存储结构
    StringBuffer sb = new StringBuffer();
    // 判断这个元素是否被访问 避免重复使用同一个char字符
    boolean visit[];

    public String[] permutation(String s) {
        chars = s.toCharArray();
        visit = new boolean[s.length()];
        // 先对char数组排序 防止 aab这种出现重复的排列
        Arrays.sort(chars);
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    public void dfs(int depth) {
        // 当深度达到了char的length说明已经完成 返回
        if (depth == chars.length) {
            list.add(sb.toString());
            return;
        }
        // 对数组中的每一个char都遍历一次
        for (int i = 0; i < chars.length; i++) {
            // 如果这个字符在前一次递归中已经使用 那么跳过
            // 如果这个这个字符和前一个字符相同说明在for循环的上一次已经有了这个排列比如aab
            // 但是需要拍出一种情况 就是前一个a是在上一层通道的而不是这一层用到的 因此如果是上一层用到的那么visit一定是true
            // 如果visit 为false 且 这个字符和上一个字符相同那么 说明上一层for循环已经使用过这个字符
            if (visit[i]||(i>0&&!visit[i-1]&&chars[i]==chars[i-1])) {
                continue;
            }
            // 将访问过设置为true
            visit[i]=true;
            sb.append(chars[i]);
            dfs(depth + 1);
            // 回到这一层 将访问过设置为false 因为回到了这一层 继续下一个字符的遍历
            visit[i]=false;
            // 并需要将这个字符从结果中删除
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
