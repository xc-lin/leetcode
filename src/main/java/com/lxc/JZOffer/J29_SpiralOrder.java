package com.lxc.JZOffer;

public class J29_SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        int []result=new int[0];
        if (matrix==null){
            return result;
        }
        int length2= matrix.length;
        if (length2 == 0) {
            return result;
        }
        int length1 = matrix[0].length;
        result= new int[length1*length2];
        length2--;
        length1--;
        int left=0,upper=0;
        int count=0;
        while (true){
            for (int i = left; i <=length1; i++) {
                result[count]=matrix[upper][i];
                count++;
            }
            if (++upper>length2){
                break;
            }
            for (int j = upper; j <=length2; j++) {
                result[count]=matrix[j][length1];
                count++;
            }
            if (--length1<left){
                break;
            }
            for (int i = length1; i >=left; i--) {
                result[count]=matrix[length2][i];
                count++;
            }
            if (--length2<upper){
                break;
            }
            for (int j = length2; j >=upper; j--) {
                result[count]=matrix[j][left];
                count++;
            }
            if (++left>length1){
                break;
            }


        }
        return result;
    }
}
