package com.lxc.JZOffer2;

public class J67_StrToInt {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int result=0;
        int length = str.length();
        char c[] = str.toCharArray();
        int count = 0;
        while (count < length && c[count] == ' ') {
            count++;
        }
        int sign = 1;
        if (count < length && c[count] == '-') {
            sign = -1;
            count++;
        }else if (count < length&&c[count] == '+') {
            count++;
        }
        while (count < length && c[count] <= '9' && c[count] >= '0') {

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (c[count] - '0') > 7)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + c[count] - '0';
            count++;
        }
        return sign * result;

    }
}
