package com.lxc.JZOffer;

public class J67_StrToInt {
    public int strToInt(String str) {
        char chars[] = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        boolean start = false;
        boolean symbol=false;
        for (char c : chars) {
            // 如果是有效数字
            if (c >= '0' && c <= '9') {
                // 如果在这里之前都没有有效字符 这个字符就是第一个有效字符
                if (!start) {
                    start = true;
                }
                // 添加到sb中
                sb.append(c);

            }
            // 对负号单独处理
            else if ((c == '-'||c == '+') && !start) {
                start=true;
                symbol=true;
                sb.append(c);
            }
            // 当已经出现第一个有效字符后 出现了不是数组就退出
            else if ((c > '9' || c < '0') && start){
                break;
            }

            if (!start && c!='+' && c!='-'&& c!=' '&& (c > '9' || c < '0')){
                return 0;
            }
            if (sb.length()>9) {
                long temp = Long.parseLong(sb.toString());
                if (temp > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (temp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }

        }
        if (sb.length() == 0||(sb.length()==1&&symbol)) {
            return 0;
        }

        long temp = Long.parseLong(sb.toString());
        if (temp > Integer.MAX_VALUE ) {
            return Integer.MAX_VALUE;
        }else if (temp < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) temp;
    }

    public int strToIntBest(String str) {
        char chars[] = str.toCharArray();
        int sign=1,result=0;
        int length=str.length();
        if (length==0){
            return 0;
        }
        int i=0;
        while(i<length){
            if (chars[i]==' '){
                i++;
            }else {
                break;
            }

        }
        if (i==length){
            return 0;
        }
        if (chars[i]=='-'||chars[i]=='+'){
            if (chars[i]=='-'){
                sign=-1;
            }
            i++;
        }
        for (int j = i; j < length; j++) {
            // 在前面都已经对空格和正负号做处理了如果有一个 不是数字直接break

            if ((chars[j] > '9' || chars[j] < '0')) {
                break;
            }
            // 最巧妙的一步在这里  他提前判断是不是已经越界 因为后面一定要乘10
            // 如果刚好相等 则要看是不是最后一位大于7
            // 如果刚好是7 正负都不越界
            // 如果是8 正越界 负数没有越界
            // 但是刚好在界线上直接返回没有问题
            if (result > Integer.MAX_VALUE / 10 || (chars[j] > '7' && result == Integer.MAX_VALUE / 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + (chars[j] - '0');

        }
        return result*sign;

    }

    public static void main(String[] args) {
        System.out.println(new J67_StrToInt().strToIntBest("2147483646"));
    }
}
