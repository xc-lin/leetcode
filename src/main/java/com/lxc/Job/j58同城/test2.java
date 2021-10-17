package com.lxc.Job.j58同城;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class test2 {
    public int[] rec(int[][] results)  {
//        String temp="";
//        for (int i = 0; i <results.length; i++) {
//            temp+=Arrays.toString(results[i])+"\n";
//        }
//        throw new Exception(temp);
        return sort(results, 0, results.length - 1);
    }

    public int[] sort(int[][] results, int left, int right) {
        if (right - left == 1) {
            return merge(results[left], results[right]);
        } else if (left == right) {
            return results[left];
        }
        int mid = (left + right) / 2;
        int temp1[] = sort(results, left, mid);
        int temp2[] = sort(results, mid + 1, right);
        return merge(temp1, temp2);
    }

    public int[] merge(int[] a, int[] b) {
        Arrays.sort(a);
        reverse(a);
        Arrays.sort(b);
        reverse(b);
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, count = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                result[count++] = a[i];
                i++;
            } else if (a[i] < b[j]) {
                result[count++] = b[j];
                j++;
            } else {
                result[count++] = b[j];
                i++;
                j++;
            }
        }
        while (i < a.length) {
            result[count++] = a[i];
            i++;
        }
        while (j < b.length) {
            result[count++] = b[j];
            j++;
        }
        return result;
    }

    public void reverse(int[] array) {
        int i = 0;
        for (int j = array.length - 1; j > i; ++i) {
            int tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            --j;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new test2().rec(new int[][]{{987, 947, 876,811}, {10003, 999, 965}, {559, 435, 332,235,107},{907,276,107}})));
    }
}
