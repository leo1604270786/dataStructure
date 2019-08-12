package com.zys.sort;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description: 冒泡排序
 * @author: Leo
 * @create: 2019-05-23 20:40
 **/
public class BubbleSort {

    /**
     * @Description: 简单冒泡排序
     * @Param: [arr] 待排序数组
     * @Author: Leo
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        //每次循环都将当前元素与后一个比较
        //一次循环过后最大的数将会被交换至最后
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //当前元素比后一个大 交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第 " + (i + 1) + " 趟排序后：");
//            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 冒泡排序（优化）
     * @param arr
     */
    public static void bubbleSort2(int[] arr){
        int temp = 0;
        //记录某趟比较中，是否发生了交换
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //当前元素比后一个大 交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //System.out.println("第 " + (i + 1) + " 趟排序后：");
            //System.out.println(Arrays.toString(arr));
            //在这一趟比较中 未发生交换（即数组已经有序）
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }
}