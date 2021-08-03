package com.lxc.JZOffer;

public class J46_TranslateNum {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int length = numStr.length();
        // 因为要用opt[i-1] 和 opt[i-2]所以要+1
        int[] opt = new int[String.valueOf(num).length() + 1];

        opt[0] = 1;
        // 这个才是第一个的值
        opt[1] = 1;
        for (int i = 1; i < length; i++) {
            // 看看和前面的那个数字能不能组成两位数翻译成字母
            int a=Integer.parseInt(numStr.substring(i - 1, i + 1));
            // 如果可以和前面那个数，翻译成字符(大于10小于26) 如果是06 这两个字符不能翻译成字符
            // 首先先加上前面的数量，因为这个字符首先可以单独翻译成一个字符，然后再加上opt[i-2]代表了两个字符相结合翻译为一个字符的情况
            if (10<= a&&a< 26)
                opt[i + 1] = opt[i] + opt[i - 1];
            else {
                // 这个字符只能单独存在
                opt[i+1] = opt[i];
            }
        }
        return opt[length];
    }
}
