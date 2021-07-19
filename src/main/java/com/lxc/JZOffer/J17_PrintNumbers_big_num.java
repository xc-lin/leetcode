package com.lxc.JZOffer;

public class J17_PrintNumbers_big_num {
    int n;
    char num[],loop[]={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuffer result=new StringBuffer();
    public String printNumbers(int n) {
        this.n=n;
        num=new char[n];
        dfs(0);
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
    public void dfs(int x){
        if (x==n){
            String s= new String(num);
            int a = Integer.parseInt(s);
            if (a==0){
                return;
            }
            result.append(String.valueOf(a)+",");
            return;
        }
        for (char c : loop){
            num[x]=c;
            dfs(x+1);
        }

    }
}
