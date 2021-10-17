package com.lxc.Job.redBook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class test3 {

    public int test(int n, Date a[][]) {
        if (a.length==0||a[0].length==0){
            return 0;
        }
        long opt[] = new long[n];
        int num[] = new int[n];
        opt[0] = (a[0][1].getTime() - a[0][0].getTime()) / 1000 / 60;
        num[0] = 1;
        for (int i = 1; i < n; i++) {
            long max = opt[0];
            int index = 0;
            for (int j = 0; j < i; j++) {
                if (a[i][0].getTime() >= a[j][1].getTime()) {
                    if (max < opt[j]) {
                        max = opt[j];
                        index = j;
                    }
                }
            }
            num[i] = num[index] + 1;
            opt[i] = max + (a[i][1].getTime() - a[i][0].getTime()) / 1000 / 60;
        }
        int result = (int) opt[0];
        int index = 0;
        for (int i = 0; i < opt.length; i++) {
            if (result < opt[i]) {
                result = (int) opt[i];
                index = i;
            }
        }
        return num[index] > 2 ? result : 0;

    }

}

public class Main {
    public static void main(String args[]) throws ParseException {
        Scanner cin = new Scanner(System.in);
        List<Date[]> list = new ArrayList<>();
        int n = 0;
        int total = 0;
        int count = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        while (cin.hasNext()) {
            if (count == 0) {
                n = Integer.parseInt(cin.nextLine());
            } else {
                Date temp[] = new Date[2];
                String strings[] = cin.nextLine().split("-");
                for (int i = 0; i < strings.length; i++) {
                    temp[i] = sdf.parse(strings[i]);
                }
                list.add(temp);
            }
            if (count == n) {
                break;
            }
            count++;

        }
        System.out.println(new test3().test(n, list.toArray(new Date[n][n])));
    }
}
