package com.zys.sort;

/**
 * @program: dataStructure
 * @description: 快速排序
 * @author: Leo
 * @create: 2019-08-01 16:12
 **/
public class QuickSort {
    /**
     * 快速排序
     * @param arr 待排序数组
     * @param left 待排序部分左索引
     * @param right 待排序部分右索引
     */
    public static void quickSort(int[] arr, int left, int right){
        if (right < left)
            return;
        //储存基准值（取最左边的数）
        int temp = arr[left];
        int l = left, r = right;
        while (l < r){
            //从右向左找第一个比基准值小的数
            while (arr[r] >= temp && r > l){
                r--;
            }
            //从左向右找第一个比基准值大的数
            while (arr[l] <= temp && l < r){
                l++;
            }
            //如果 l 还在 r 的左边
            if (l < r){
                //交换下标 l、r 的值
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }
        }
        //此时 l == r，交换基准值和 l(r) 对应的值
        arr[left] = arr[l];
        arr[l] = temp;
        //对左边部分进行快速排序
        quickSort(arr,left,l-1);
        //对右边部分进行快速排序
        quickSort(arr,l+1,right);
    }
}