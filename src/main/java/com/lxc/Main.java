package com.lxc;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Integer;
import java.lang.Double;
public class Main{
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line1=scanner.nextLine();
        String line2=scanner.nextLine();
        double a =Double.valueOf(line1.substring(2));
        int b = Integer.valueOf(line2.substring(2));
        double result=a;
        for(int i=1;i<b;i++){
            result+=a;
            a=a/2;
        }

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(result)+"米");


    }
}
