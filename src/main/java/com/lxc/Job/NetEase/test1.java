package com.lxc.Job.NetEase;

public class test1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr float浮点型一维数组 非空无序数组
     * @return float浮点型
     */
    public float median(float[] arr) {

        // write code here
        if (arr==null||arr.length==0){
            return 0.0f;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        int index = partition(arr, left, right);
        while (index != mid) {
            if (index < mid) {
                index=partition(arr, index + 1, right);
            } else if (index > mid) {
                index=partition(arr, left, index - 1);
            }
        }
        return arr[mid];
    }

    public int partition(float[] arr, int left, int right) {
        float pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new test1().median(new float[]{5.0f,5.0f,5.0f}));
    }

}
