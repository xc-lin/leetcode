package com.lxc.JZOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 约瑟夫环
 */
public class J62_LastRemaining {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() != 1) {
            int temp = (i + m - 1) % list.size();
            list.remove(temp);
            i = temp;
        }
        return list.get(0);

    }

    /**
     * 比如 n=5 m=3
     * 0,1,2,3,4
     * 3,4,0,1
     * 1,3,4
     * 1,3
     * 3
     * 我们可以倒推回去
     * 如果最后一个是一位数，那么很明显他的前面应该已经过了3个数字所以我们可以将最后倒数第二轮写为
     * x,x,x,3 但是倒数二轮只有两个数，所以我们要除余2 这样才是这个数第二轮真实的位置 (0+3)%2=1 由此我们已经知道了这个数在倒数第二轮的位置
     * 倒数第三轮的位置是x,x,x,a,3， 继续除余 (1+3)%3=1 所以在倒数第三轮这个数在第一个位置
     * 所以倒数第四轮是 x,x,x,a,3 继续除余 (1+3)%4=0 所以在倒数第三轮这个数在第0个位置
     * 所以倒数第五轮是 x,x,x,3 继续除余 (0+3)%5=3 所以在倒数第三轮这个数在第3个位置
     * 因为此时我们迭代到的数组大小已经是题目要求的n 因此我们已经得到答案而且第几个位置就是他的值
     * 因此直接返回
     * @param n 有几个数
     * @param m 删出第几个
     * @return
     */

    public int lastRemainingBest(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result+m)%i;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new J62_LastRemaining().lastRemaining(5, 2));
    }
}
