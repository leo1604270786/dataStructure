package com.zys.sort;

/**
 * @program: dataStructure
 * @description: 归并排序
 * @author: Leo
 * @create: 2019-08-01 16:46
 **/
public class MergeSort {
    /**
     * 归并排序
     *
     * @param arr   待排序数组
     * @param left  待排序左边部分开始索引
     * @param right 待排序右边部分开始索引
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //对左边部分分解
            mergeSort(arr, left, mid);
            //对右边部分分解
            mergeSort(arr, mid + 1, right);
            //合并
            merge(arr, left, mid, right);
        }
    }

    /**
     * 合并[left,mid] 与 [mid+1,right]两部分
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        //l,r分别指向左边部分、右边部分开始索引
        int l = left, r = mid + 1;
        //临时数组
        int[] temp = new int[right - left + 1];
        //临时数组索引
        int t = 0;
        //1.遍历两部分，直到有一边全部遍历完
        while (l <= mid && r <= right) {
            //如果左边部分当前元素较小
            if (arr[l] < arr[r]) {
                //将arr[l]放入临时数组中
                temp[t] = arr[l];
                l++;
                t++;
            } else {
                //将arr[r]放入临时数组中
                temp[t] = arr[r];
                r++;
                t++;
            }
        }
        //2.有一边遍历完，将另一边剩余元素全部放入临时数组中
        while (l <= mid) {
            temp[t] = arr[l];
            l++;
            t++;
        }
        while (r <= right) {
            temp[t] = arr[r];
            r++;
            t++;
        }
        //3.将当前合并好的部分拷贝到原数组
        t = 0;
        l = left;
        while (l <= right) {
            arr[l] = temp[t];
            l++;
            t++;
        }
    }
}