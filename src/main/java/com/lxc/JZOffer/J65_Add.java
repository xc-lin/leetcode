package com.lxc.JZOffer;

public class J65_Add {
    public int add(int a, int b) {
        // 结果
        int result = a;
        int mask = 1;
        // 是否进位
        boolean carry=false;
        for (int i = 0; i < 32; i++) {
            // 如果两个值不一样那么可以直接为1 如果有进位那么就是1 和 1 又变成0 进位不变
            if ((a & mask) != (b & mask) ){
                if (carry){
                    // 将这个位 置为0
                    result&=~(1<<i);
                }else {
                    // 如果没有进位 那么置为1
                    result|=1<<i;
                }
            }
            if ((a & mask) ==  (b & mask) ) {
                // 如果两个位置都是1
                if ((a & mask) ==1){
                    // 如果有进位 那么这个位置还是1， 且进位不变因此不用操作
                    // 如果没有进位 那这个位置置0 进位 为1
                    if (!carry){
                        result&=~(1<<i);
                        carry=true;
                    }

                }else {
                    // 如果两个位置都是0 如果没有进位 那么这个位置还是0
                    // 如果有进位 这个位置置为1 进位取消
                    if(carry){
                        result|=1<<i;
                        carry=false;
                    }
                }

            }
            // 每次看一位
            a >>= 1;
            b >>= 1;
        }

        return result;

    }
    public int addBest(int a, int b) {
        // 这个方法巧妙在直接所有的都看了
        // 异或操作可以看出 一个是0 一个是1的位置 即无进位的位置，第一次这个位置可以直接置为1
        int diff= a^b;
        // 用与操作 可以看出哪些位置是 都是1 需要进位
        // 而这些进位操作都是给下一位的 因此需要左移1位
        int carry=(a&b)<<1;
        // 结束条件则是无进位 因为如果第一次就没有进位说明diff已经是结果了
        while (carry!=0){
            // 其实这里面就是重复上面的操作 diff和carry相加 直到无进位 如果此时没有进位了那就说明最后的进位也都加到 结果里了
            // 和我们的加法是一样的 如果没有进位的话一步就可以结束， 如果有进位那么需要继续加
            int tempDiff=diff;
            diff=diff^carry;
            carry=(tempDiff&carry)<<1;
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(new J65_Add().addBest(7,7));
    }
}
