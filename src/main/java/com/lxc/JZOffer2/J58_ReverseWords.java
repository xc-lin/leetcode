package com.lxc.JZOffer2;

public class J58_ReverseWords {
    public String reverseWords(String s) {
        if (s==null||s.length()==0){
            return null;
        }
        char c[] = s.toCharArray();
        int length = c.length;
        int left = 0;
        int right = length - 1;
        while (left <= right && c[left] == ' ') {
            left++;
        }
        while (left <= right && c[right] == ' ') {
            right--;
        }
        StringBuffer sb = new StringBuffer();
        while (left <= right) {
            int temp=right;
            while (right>=left&&c[right] != ' '){
                right--;
            }
            sb.append(s.substring(right+1,temp+1));
            sb.append(' ');
            while (right>=left&&c[right]==' '){
                right--;
            }

        }
        if (sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new J58_ReverseWords().reverseWords(" "));
    }
}
