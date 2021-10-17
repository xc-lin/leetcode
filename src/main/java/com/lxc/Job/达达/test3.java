package com.lxc.Job.达达;

import java.util.*;

class K{
    int index;
    int value;

    public K(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
public class test3 {
    public static int maxCoins(int[] array) {

        int length = array.length;
        int result =0;
        Map<Integer,Integer> map = new HashMap<>();
        K[] k=new K[array.length-2];
        // todo 需要编写的核心代码
        for (int i = 1; i < array.length-1; i++) {
            k[i-1] = new K(i,array[i]);
            map.put(i,array[i]);
        }
        map.put(0,array[0]);
        map.put(length-1,array[length-1]);

        Arrays.sort(k, new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                return o1.value-o2.value;
            }
        });
        for (int i = 0; i < array.length-2; i++) {
            int index = k[i].index;
            int j=1;
            while (!map.containsKey(index-j)){
                j++;
            }
            int l=1;
            while (!map.containsKey(index+l)){
                l++;
            }
            result+=map.get(index)*map.get(index+l)*map.get(index-j);
            map.remove(index);
        }
        result+=array[0]*array[array.length-1];
        result+=Math.max(array[0],array[array.length-1]);
        return result;


    }

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] arrayStr = str.split(",");
            int[] array = new int[arrayStr.length];
            for (int i = 0; i < arrayStr.length; i++) {
                array[i] = Integer.parseInt(arrayStr[i].trim());
            }
            System.out.println(maxCoins(array));
        }

    }
}
//73,31,51,33,94,45,75,67,99,49,0,2,77,97,89,89,24,66,27