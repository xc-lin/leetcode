package com.lxc.Job.Tencent;

public class testInterview {
    public static boolean test1(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        char c3[] = s3.toCharArray();
        boolean opt[][] = new boolean[c1.length+1][c2.length+1];
        opt[0][0]=true;
        for (int i = 0; i < length1; i++) {
            if (c3[i]==c1[i]){
                opt[i+1][0]=true;
            }else {
                break;
            }
        }
        for (int i = 0; i < length2; i++) {
            if (c3[i]==c2[i]){
                opt[0][i+1]=true;
            }else {
                break;
            }
        }
        for (int i = 1; i < length1+1; i++) {
            for (int j = 1; j <length2+1 ; j++) {
                if (opt[i][j-1]&&c3[i+j-1]==c2[j-1]){
                    opt[i][j]=true;
                }
                if (opt[i-1][j]&&c3[i+j-1]==c1[i-1]){
                    opt[i][j]=true;
                }
            }
        }
        return opt[length1][length2];
    }

    public static void main(String[] args) {
//        System.out.println(test1("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(test1("abc", "xyz", "axybcz"));
    }
}
