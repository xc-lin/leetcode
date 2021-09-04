package com.lxc.hostest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L301_删除无效的括号 {
    char[] c;
    HashSet<String> set = new HashSet<>();
    int len;

    List<String> result = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        c = s.toCharArray();
        int left = 0;
        int right = 0;
        len = s.length();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                // 没有和他对应的那就是多余的 需要删除的
                left++;
            }
            if (c[i] == ')') {
                // 如果没有左括号那么就要删除右括号
                if (left == 0) {
                    right++;
                } else {
                    // 如果有左括号那么配对
                    left--;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        dfs(0, 0,0,left, right, sb);
        return result;

    }

    public void dfs(int index, int leftCount, int rightCount, int leftRemoved, int rightRemoved, StringBuffer sb) {
        if (index == len) {
            if (leftRemoved == 0 && rightRemoved == 0 && set.add(sb.toString())) {

                result.add(sb.toString());
            }
            return;
        }
        if (c[index] == '(' && leftRemoved > 0) {
            dfs(index + 1, leftCount, rightCount, leftRemoved - 1, rightRemoved, sb);
        }
        if (c[index] == ')' && rightRemoved > 0) {
            dfs(index + 1, leftCount, rightCount, leftRemoved, rightRemoved - 1, sb);
        }
        sb.append(c[index]);
        if (c[index] != '(' && c[index] != ')') {
            dfs(index + 1, leftCount, rightCount, leftRemoved, rightRemoved, sb);
        }else if (c[index]=='('){
            dfs(index + 1, leftCount+1, rightCount, leftRemoved, rightRemoved, sb);
        }else if (rightCount<leftCount){
            dfs(index + 1, leftCount, rightCount+1, leftRemoved, rightRemoved, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new L301_删除无效的括号().removeInvalidParentheses("(a)())()").toString());
    }
}
