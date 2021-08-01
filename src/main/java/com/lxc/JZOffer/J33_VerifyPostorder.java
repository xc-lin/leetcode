package com.lxc.JZOffer;

public class J33_VerifyPostorder {
    int[] postorder;

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        int root = postorder.length - 1;
        return recur(root, 0, postorder.length - 1);

    }

    public boolean recur(int root, int left, int right) {
        int newRoot = left;
        boolean flag = false;
        if (left >= right) {
            return true;
        }

        for (int i = left; i <= right; i++) {

            if (flag && postorder[i] < postorder[root]) {
                return false;
            }
            if (!flag && postorder[i] > postorder[root]) {
                newRoot = i - 1;
                flag = true;
            }

        }
        return recur(newRoot, left, newRoot - 1) && recur(right, newRoot + 1, right - 1);

    }


    public boolean verifyPostorderBest(int[] postorder) {
        this.postorder = postorder;

        return recurBest(0, postorder.length - 1);

    }

    public boolean recurBest(int left, int right) {
        if (left >= right) {
            return true;
        }
        int p =left;
        while (postorder[p]<postorder[right])p++;
        int newLeftRoot=p;
        while (postorder[p]>postorder[right])p++;

        return p==right&&recurBest( left, newLeftRoot-1) && recurBest( newLeftRoot , right - 1);
    }
}
