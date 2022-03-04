package com.lxc.Job.leyuansu;



import com.lxc.Job.leyuansu.bean.Sqare;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Service {
    public static void main(String[] args) {
        Sqare sqare = new Sqare(2, 2, 1);
        Service service = new Service();
        service.init(sqare);
        int[][] matrix = sqare.getMatrix();
        int[][] matrixUser=new int[sqare.getM()][sqare.getN()];
        for (int i = 0; i < sqare.getM(); i++) {
            Arrays.fill(matrixUser[i],-2);
        }

        for (int i = 1; i <= sqare.getM(); i++) {
            for (int j = 1; j <= sqare.getN(); j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        showMatrix(matrixUser);
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入坐标x,y");
        int total =sqare.getM()* sqare.getN();

        do{
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            if (x<0||y<0||x>=sqare.getM()||y>= sqare.getN()){
                System.out.println("输入错误请重新输入");
                scanner.nextLine();
                continue;
            }
            if (matrix[x+1][y+1]==-1) {
                System.out.println("被雷炸死了，游戏结束");
                return;
            }else {
                matrixUser[x][y]=matrix[x+1][y+1];
                total--;
                if (total==sqare.getNum()){
                    System.out.println("恭喜你，已通关！！！");
                    return;
                }
            }
            showMatrix(matrixUser);
            scanner.nextLine();
            System.out.println("输入坐标x,y");
        }while (scanner.hasNext());


    }
    public static void showMatrix(int[][]  matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void init(Sqare sqare) {
        Random random = new Random();
        int num = sqare.getNum();
        int[][] matrix = sqare.getMatrix();
        while (num > 0) {
            int i = random.nextInt(sqare.getM())+1;
            int j = random.nextInt(sqare.getN())+1;
            if (matrix[i][j] != -1) {
                matrix[i][j] = -1;
                num--;
                for (int k = -1; k < 2; k++) {
                    if (matrix[i+k][j-1]!=-1) matrix[i+k][j-1]++;
                    if (matrix[i+k][j]!=-1) matrix[i+k][j]++;
                    if (matrix[i+k][j+1]!=-1) matrix[i+k][j+1]++;
                }

            }
        }
        sqare.setMatrix(matrix);
    }
}
