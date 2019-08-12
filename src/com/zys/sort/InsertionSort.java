package com.zys.sort;

/**
 * @program: dataStructure
 * @description: 插入排序
 * @author: Leo
 * @create: 2019-05-23 20:41
 **/
public class InsertionSort {
    /**
    * @Description: 直接插入排序
    * @Param: [arr] 待排序数组
    * @Author: Leo
    */
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            //先暂存当前待插入的元素
            int curr = arr[i];
            int j = i;
            for (; j > 0 && curr < arr[j-1]; j--){
                //将前一个元素赋值到当前位置（代替每次交换）
                arr[j] = arr[j-1];
            }
            //到达合适位置 赋值
            arr[j] = curr;
        }
    }
}