package com.lxc.JZOffer2;

public class J58_ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        if (s==null||s.length()==0){
            return "";
        }
        StringBuffer sb =new StringBuffer();
        sb.append(s.substring(n));
        sb.append(s, 0, n);
        return sb.toString();
    }
}
