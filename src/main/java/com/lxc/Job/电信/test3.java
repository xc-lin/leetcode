package com.lxc.Job.电信;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x0=scanner.nextInt();
        int y0=scanner.nextInt();
        int x1=scanner.nextInt();
        int y1=scanner.nextInt();
        int x2=scanner.nextInt();
        int y2=scanner.nextInt();
        int x3=scanner.nextInt();
        int y3=scanner.nextInt();

        int length1=(x0-x1)*(x0-x1)+(y0-y1)*(y0-y1);
        int length2=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
        int length3=(x3-x2)*(x3-x2)+(y3-y2)*(y3-y2);
        int length4=(x0-x3)*(x0-x3)+(y0-y3)*(y0-y3);
        boolean flag=true;
        if (length1==length2&&length2==length3&&length3==length4){
            int tempX1=x0-x2;
            int tempy1=y0-y2;
            int tempX2=x1-x3;
            int tempy2=y1-y3;
            if (tempX1*tempX2+tempy1*tempy2==0){
                System.out.println("YES");
                flag=false;
            }


        }
        if (flag){
            System.out.println("NO");
        }


    }
}
