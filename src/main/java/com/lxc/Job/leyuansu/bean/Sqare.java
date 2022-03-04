package com.lxc.Job.leyuansu.bean;

public class Sqare {
    private int[][] matrix;
    private int m;
    private int n;
    private int num;

    public Sqare(int m, int n, int num) {
        this.num = num;
        this.m = m;
        this.n = n;
        this.matrix = new int[m + 2][n + 2];
    }

    public Sqare() {
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
