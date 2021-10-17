package com.lxc.Job.用友;

public class test1 {
    public boolean isContain(String shortname, String fullname) {
        char[] shortChars = shortname.toCharArray();
        char[] fullChars = fullname.toCharArray();
        int shortIndex = 0;
        int fullIndex = 0;
        while (shortIndex < shortname.length() && fullIndex < fullname.length()) {
            if (shortChars[shortIndex] != fullChars[fullIndex]) {
                fullIndex++;
            } else {
                fullIndex++;
                shortIndex++;
            }
        }
        if (shortIndex == shortname.length()) {
            return true;
        } else {
            return false;
        }
    }
}
