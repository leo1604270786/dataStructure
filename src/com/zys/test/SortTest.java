package com.zys.test;

import com.zys.sort.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description: 排序测试类
 * @author: Leo
 * @create: 2019-05-23 20:42
 **/
public class SortTest {
    int[] arr;

    @Before
    public void generateUnSortedArray() {
        arr = new int[]{5, 3, 7, 8, 1, 9, 4, 2, 6};
    }

    @Test
    public void testSelectionSort() {
        printArray(arr);
        SelectionSort.selectionSort2(arr);
        printArray(arr);
    }

    @Test
    public void testInsertionSort() {
        printArray(arr);
        InsertionSort.insertionSort(arr);
        printArray(arr);
    }

    @Test
    public void testBubbleSort() {
//        System.out.println("未排序数组：");
//        System.out.println(Arrays.toString(arr));
        //生成数组
        generateRandomArray(80000);
        //复制一份
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        long startTime = System.currentTimeMillis();
        BubbleSort.bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("优化前冒泡排序花费时间：" + (endTime - startTime) + " ms");
//        System.out.println("排序后数组：");
//        System.out.println(Arrays.toString(arr));

        startTime = System.currentTimeMillis();
        BubbleSort.bubbleSort2(arr2);
        endTime = System.currentTimeMillis();
        System.out.println("优化后冒泡排序花费时间：" + (endTime - startTime) + " ms");
//        System.out.println("排序后数组：");
//        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testCompare() {
        //生成数组
        generateRandomArray(80000);
        //复制两份
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        int[] arr3 = new int[arr.length];
        System.arraycopy(arr, 0, arr3, 0, arr.length);

        long startTime = System.currentTimeMillis();
        BubbleSort.bubbleSort2(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序花费时间：" + (endTime - startTime) + " ms");


        startTime = System.currentTimeMillis();
        SelectionSort.selectionSort2(arr2);
        endTime = System.currentTimeMillis();
        System.out.println("选择排序花费时间：" + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        InsertionSort.insertionSort(arr3);
        endTime = System.currentTimeMillis();
        System.out.println("插入排序花费时间：" + (endTime - startTime) + " ms");
    }

    @Test
    public void testQuickSort() {
//        printArray(arr);
//        QuickSort.quickSort(arr,0,arr.length-1);
//        printArray(arr);
        //生成数组
        generateRandomArray(8000000);
        long startTime = System.currentTimeMillis();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序花费时间：" + (endTime - startTime) + " ms");
    }

    @Test
    public void testMergeSort() {
//        printArray(arr);
//        MergeSort.mergeSort(arr, 0, arr.length - 1);
//        printArray(arr);
        //生成数组
        generateRandomArray(8000000);
        long startTime = System.currentTimeMillis();
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("归并排序花费时间：" + (endTime - startTime) + " ms");
    }

    @Test
    public void testShellSort() {
//        printArray(arr);
//        ShellSort.shellSort(arr);
//        printArray(arr);
        //生成数组
        generateRandomArray(80000);
        long startTime = System.currentTimeMillis();
        ShellSort.shellSort2(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序花费时间：" + (endTime - startTime) + " ms");
    }

    @Test
    public void testCompare2() {
        //生成数组
        generateRandomArray(80000);
        //复制两份
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        int[] arr3 = new int[arr.length];
        System.arraycopy(arr, 0, arr3, 0, arr.length);

        long startTime = System.currentTimeMillis();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序花费时间：" + (endTime - startTime) + " ms");


        startTime = System.currentTimeMillis();
        MergeSort.mergeSort(arr2, 0, arr2.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("归并排序花费时间：" + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        ShellSort.shellSort2(arr3);
        endTime = System.currentTimeMillis();
        System.out.println("希尔排序花费时间：" + (endTime - startTime) + " ms");
    }

    @Test
    public void testRadixSort() {
//        printArray(arr);
//        RadixSort.radixSort(arr);
//        printArray(arr);
        //生成数组
        generateRandomArray(8000000);
        long startTime = System.currentTimeMillis();
        RadixSort.radixSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("基数排序花费时间：" + (endTime - startTime) + " ms");
    }

    @Test
    public void testHeapSort() {
//        System.out.println(Arrays.toString(arr));
//        HeapSort.heapSort(arr);
//        System.out.println(Arrays.toString(arr));
        //生成数组
        generateRandomArray(8000000);
        long startTime = System.currentTimeMillis();
        HeapSort.heapSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序花费时间：" + (endTime - startTime) + " ms");
    }

    @Test
    public void testCompare3() {
        //生成数组
        generateRandomArray(8000000);
        //复制一份
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        long startTime = System.currentTimeMillis();
        RadixSort.radixSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("基数排序花费时间：" + (endTime - startTime) + " ms");


        startTime = System.currentTimeMillis();
        HeapSort.heapSort(arr2);
        endTime = System.currentTimeMillis();
        System.out.println("堆排序花费时间：" + (endTime - startTime) + " ms");
    }

    /**
     * 生成有n个元素的随机数组
     *
     * @param n 数组元素个数
     */
    public void generateRandomArray(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * n * 10);
        }
    }


    private void printArray(int[] a) {
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}