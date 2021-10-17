package com.lxc.Job.锐明科技;

public class test3 {
    public boolean powerOf4 (int i) {
        return (i&(i-1))==0 && (i&~0x555555)==0;
    }

    public static void main(String[] args) {
        System.out.println(new test3().powerOf4(5));
    }
}
