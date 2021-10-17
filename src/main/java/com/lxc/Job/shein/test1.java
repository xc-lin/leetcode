package com.lxc.Job.shein;

public class test1 {
    public static String changespaceto20 (String str) {
//        String a=str.replace(" ","%20");
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(changespaceto20("a  b    c"));
    }
}
