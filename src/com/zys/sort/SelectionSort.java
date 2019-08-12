package com.zys.sort;

/**
 * @program: dataStructure
 * @description: 选择排序
 * @author: Leo
 * @create: 2019-05-23 20:40
 **/
public class SelectionSort {

    /**
    * @Description: 简单选择排序
    * @Param: [arr] 待排序数组
    */
    public static void selectionSort(int[] arr){
        //记录最小值的索引
        int minIndex = 0;
        //每次循环选择一个最小的数放到未排序部分最前面
        for (int i = 0; i < arr.length-1; i++){
            minIndex = i;
            for (int j = i+1; j < arr.length; j++){
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }
            //将最小值与当前未排序部分的第一个元素进行交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 简单优化后的选择排序
     * @param arr
     */
    public static void selectionSort2(int[] arr){
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++){
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //如果最小值索引变动了，才交换
            if (minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

    }
}