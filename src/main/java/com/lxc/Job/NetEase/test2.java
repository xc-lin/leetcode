package com.lxc.Job.NetEase;

import java.util.Scanner;

public class test2 {

    int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String names[] = scanner.nextLine().split(" ");
        if (names.length==0||(names.length==1&&names[0].equals(""))){
            System.out.println(0);
            return;
        }
        String article = scanner.nextLine();
        if (article.length()==0){
            System.out.println(0);
            return;
        }
        int count=0;
        for (String name : names) {
            String tempArticle = article;
            while (tempArticle.length() >= name.length()) {
                int firstPlace = tempArticle.indexOf(name);
                if (firstPlace == -1) {
                    break;
                }
                count++;
                tempArticle = tempArticle.substring(firstPlace + 1);
            }
        }
        System.out.println(count);
    }
}
