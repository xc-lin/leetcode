package com.lxc.Job.redBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {
    int n;
    int a[][];
    boolean visit[][];
    int count = 0,total=0;

    public int test(int n, int a[][],int total) {
        if (n==0){
            return count;
        }
        this.n = n;
        this.a = a;
        this.total=total;
        this.visit = new boolean[n][n];
        dfs(0,0);
        return count;
    }

    public void dfs(int i, int j) {

        if (i < 0 || i >= n || j < 0 || j >= n || visit[i][j] || a[i][j] == 0) {
            return;
        }
        visit[i][j]=true;
        total--;
        if (i == n - 1 &&total==0) {
            count++;
            return;
        }
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
        total++;
        visit[i][j]=false;
    }

    static class Main {
        public static void main(String args[]) {
            Scanner cin = new Scanner(System.in);
            List<int []> list = new ArrayList<>();
            int n = 0;
            int total =0;
            int count = 0;
            while (cin.hasNext()) {
                if (count == 0) {
                    n = Integer.parseInt(cin.nextLine());
                } else {
                    int temp[]=new int[n];
                    char cs[] = cin.nextLine().toCharArray();
                    for (int i = 0; i < n; i++) {
                        if (cs[i] == '.') {
                            temp[i]=1;
                            total++;
                        } else {
                            temp[i]=0;
                        }
                    }
                    list.add(temp);
                }
                if (count == n) {
                    break;
                }
                count++;

            }
            System.out.println(new test2().test(n, list.toArray(new int[n][n]),total));
        }
    }
}
