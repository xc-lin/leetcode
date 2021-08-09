package com.lxc.JZOffer;

public class J58_ReverseWords {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuffer result = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            result.append(strings[i].trim() + " ");
        }
        return result.toString().trim();
    }

    public String reverseWords2(String s) {
        char c[] = s.toCharArray();
        StringBuffer result = new StringBuffer();
        int left = s.length() - 1, right = s.length() - 1;
        while (left >= 0) {
            while (right >= 0 && c[right] == ' ') {
                right--;
                left--;
            }
            while (left >= 0 && c[left] != ' ') {
                left--;
            }
            result.append(s, left + 1, right + 1);
            result.append(" ");
            right = left;
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new J58_ReverseWords().reverseWords2("a good example"));
    }
}
