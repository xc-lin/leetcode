package com.lxc.JZOffer;

public class J58_ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        String a1 = s.substring(0, n);
        String a2 = s.substring(n);
        return a2 + a1;
    }

    public String reverseLeftWords1(String s, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = n; i < s.length()+n; i++) {
            sb.append(s.charAt(i%s.length()));
        }
        return sb.toString();
    }


}
