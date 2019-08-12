package com.zys.sort;

/**
 * @program: dataStructure
 * @description: 希尔排序
 * @author: Leo
 * @create: 2019-07-31 21:41
 **/
public class ShellSort {
    /**
     * 希尔排序（交换法） 不标准，且性能不好，基本不使用
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        //gap为步长,每次缩小为上一次1/2
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //遍历各组元素
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于 同组后一个元素，交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序（移位法）
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        int curr = 0;
        //进行分组
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            //遍历各组元素
            for (int i = gap; i < arr.length; i++){
                //暂存当前待插入的元素
                curr = arr[i];
                int j = i;
                for (; j -gap >= 0 && curr < arr[j-gap]; j -= gap){
                    arr[j] = arr[j-gap];
                }
                //找到位置，插入
                arr[j] = curr;
            }
        }
    }
}