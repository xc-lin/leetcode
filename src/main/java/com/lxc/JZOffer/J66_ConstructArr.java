package com.lxc.JZOffer;

public class J66_ConstructArr {
    /**
     * 此题的解题思路就是 result[i] 的值就是左边的乘积*右边的乘积
     * 因此需要维护两个表 一个是左边的乘积
     * 一个是右边的乘积
     * 动态规划
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int left[] = new int[a.length];
        int right[] = new int[a.length];
        right[a.length - 1] = a[a.length - 1];
        left[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            left[i] = a[i] * left[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = a[i] * right[i + 1];
        }
        int result[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int leftValue = i == 0 ? 1 : left[i - 1];
            int rightValue = i == a.length - 1 ? 1 : right[i + 1];
            result[i] = leftValue * rightValue;
        }
        return result;

    }

    /**
     * 此方法和上面思路相同
     * 但是优化了时间复杂度和空间复杂度
     * 因为他舍弃了left的维护，在result的填入和遍历过程会从左到右 在这个过程中可以得到left的累积乘积
     * @param a
     * @return
     */
    public int[] constructArrBetter(int[] a) {
        int length=a.length;
        if (length == 0) {
            return new int[0];
        }
        int right[] = new int[length];
        right[length - 1] = a[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = a[i] * right[i + 1];
        }
        int result[] = new int[length];
        int left=1;
        for (int i = 0; i < length; i++) {
            int rightValue = i == length - 1 ? 1 : right[i + 1];
            result[i] = left * rightValue;
            left=left*a[i];
        }
        return result;

    }

    public static void main(String[] args) {
        new J66_ConstructArr().constructArr(new int[]{1, 2, 3, 4});
    }
}
