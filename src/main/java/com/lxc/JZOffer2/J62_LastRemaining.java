package com.lxc.JZOffer2;

public class J62_LastRemaining {
    public int lastRemaining(int n, int m) {
        int position = 0;
        for (int i = 2; i < n+1; i++) {
            position=(m+position)%i;
        }
        return position;
    }
}
