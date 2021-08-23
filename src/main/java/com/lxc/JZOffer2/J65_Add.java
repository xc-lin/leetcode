package com.lxc.JZOffer2;

public class J65_Add {
    public int add(int a, int b) {
        int carry = 0;
        int curr = 0;
        curr = a ^ b;
        carry = a & b;
        carry<<=1;
        while (carry!=0){
            int temp=curr;
            curr = curr ^ carry;
            carry = temp & carry;
            carry<<=1;
        }
        return curr;
    }

    public static void main(String[] args) {
        new J65_Add().add(3,1);
    }
}
