package com.zys.test;

import com.zys.sort.HeapSort;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description:
 * @author: Leo
 * @create: 2019-08-13 09:38
 **/
public class HeapSortTest {
    private int[] arr;

    @Before
    public void init() {
        arr = new int[]{4, 6, 8, 5, 9};
    }

    @Test
    public void testAdjustHeap() {
        System.out.println(Arrays.toString(arr));
        HeapSort.adjustHeap(arr, 1, arr.length);
        System.out.println("第一次调整后：");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testHeapSort() {
        arr = new int[]{4, 6, 8, 5, 9, 3, 17, -8, 37, -12};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        HeapSort.heapSort(arr);
        System.out.println("堆排序后：");
        System.out.println(Arrays.toString(arr));
    }
}