package com.lxc.JZOffer2;

public class J05_ReplaceSpace {
    public String replaceSpace(String s) {
        char cs[] = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }
}
