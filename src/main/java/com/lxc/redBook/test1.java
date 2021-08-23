//package com.lxc.redBook;
//
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class test1 {
//    public int test(int n,List<List<Integer>> list){
//        int opt[][]=new int[n][2];
//        int length1= list.size();
//        for (int i = 0; i < length1; i++) {
//            if (list.get(i).size()==1){
//                opt[i][0]=opt[i-1];
//                opt[i][1]=1;
//            }else {
//                opt[i]
//            }
//        }
//    }
//
//}
//
//class Main {
//    public static void main(String args[]) {
//        Scanner cin = new Scanner(System.in);
//        List<List<Integer>> list=new ArrayList<>();
//        int n = 0;
//        int tempStones=0;
//        int count = 0;
//        while (cin.hasNextInt()) {
//            if (count == 0) {
//                n = cin.nextInt();
//                cin.nextLine();
//            }else {
//                List<Integer> temp=new ArrayList<>();
//                String line[]=cin.nextLine().split(" ");
//                for (String s:line){
//                    temp.add(Integer.parseInt(s));
//                }
//                if (temp.get(0)==0){
//                    tempStones++;
//                }
//                list.add(temp);
//            }
//            count++;
//            if (count==n){
//                break;
//            }
//        }
//        System.out.println(list.toString());
//    }
//}
