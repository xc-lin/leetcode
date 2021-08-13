package com.lxc.JZOffer2;

public class J4_CuttingRope {
    public int cuttingRope(int n) {
        // 长度为i 切成大于1段 乘起来的最大值
        int opt[] = new int[n + 1];
        opt[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            int max = opt[i - 1];
            for (int j = 2; j < i; j++) {
                // 这是从这一根绳子的第多少开始切  如果j=1 那么最后只会乘上1 所以直接忽略
                // 1、从这个地方切开 变成两段想乘
                // 2、从这个地方切开 前面有多段的形式 也就是opt[i-j]
                int temp = Math.max((i - j) * j, opt[i - j] * j);
                // 找到从哪里开始切
                if (max < temp) {
                    max = temp;
                }
            }
            opt[i] = max;
        }
        return opt[n];
    }

    public int cuttingRopeBest(int n) {
        // 长度为i 切成大于1段 乘起来的最大值
        if (n < 4) {
            return n - 1;
        }
        int result = 1;
        while (n > 4) {
            result*=3;
            n-=3;
        }
        return result*n;
    }

    public static void main(String[] args) {
        System.out.println(new J4_CuttingRope().cuttingRope(10));
    }
}
