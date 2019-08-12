package com.zys.sort;

/**
 * @program: dataStructure
 * @description: 基数排序
 * @author: Leo
 * @create: 2019-08-01 22:40
 **/
public class RadixSort {

    public static void radixSort(int[] arr) {
        //所有桶
        int[][] buckets = new int[10][arr.length];
        //每个桶中有效元素的个数
        int[] bucketCounts = new int[10];
        //获取最大位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //共进行最长位数次 分配桶，回收数据
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //获取对应位数 ，第一次为个位，第二次为十位 ...
                int value = arr[j] / n % 10;
                buckets[value][bucketCounts[value]++] = arr[j];
            }
            //遍历所有桶，按照顺序取出元素，放入原数组
            int index = 0;
            for (int k = 0; k < buckets.length; k++) {
                //如果桶中有数据
                if (bucketCounts[k] != 0) {
                    //遍历这个桶，取出所有数据放入原数组
                    for (int l = 0; l < bucketCounts[k]; l++) {
                        arr[index++] = buckets[k][l];
                    }
                }
                //每个桶处理过后，清空桶中有效数据个数
                bucketCounts[k] = 0;
            }
        }
    }
}