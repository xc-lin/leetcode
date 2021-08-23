package com.lxc.hostest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17_LetterCombinations {
    char c[];
    Map<Character, String> phoneMap;
    StringBuffer sb = new StringBuffer();
    List<String> list=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0){
            return new ArrayList<>();
        }
        phoneMap = new HashMap<Character, String>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        c = digits.toCharArray();
        dfs(0);
        return list;
    }

    public void dfs(int depth) {
        if (depth >= c.length) {
            list.add(sb.toString());
            return;
        }
        char temp[] =phoneMap.get(c[depth]).toCharArray();
        for (char ch:temp){
            sb.append(ch);
            dfs(depth+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new L17_LetterCombinations().letterCombinations("2"));
    }

}
