package com.lxc.Job.有赞;

public class test2 {
    public char[] reverseString (char[] s, int K) {
        int left=0;
        int  right=K>s.length?s.length-1:K-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return s;
    }
}
