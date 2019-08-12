package com.zys.test;

import com.zys.search.BinarySearch;
import com.zys.search.FibonacciSearch;
import com.zys.search.InterpolationSearch;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description: 查找测试类
 * @author: Leo
 * @create: 2019-05-16 17:09
 **/
public class SearchTest {
    private int[] arr;

    @Before
    public void createArr() {
        //初始化有序数组
        arr = new int[]{12, 24, 38, 43, 56, 66, 78, 87, 98, 100};
    }

    @Test
    public void testBinarySearch() {
        int key = 66;
        //int index = BinarySearch.binarySearch(arr, key);
        int index = BinarySearch.binarySearchNoRecursion(arr,key);
        if (index != -1)
            System.out.println(key + " 在数组中的索引为 " + index);
        else
            System.out.println("数组中不存在 " + key);
    }

    @Test
    public void testInterpolationSearch() {
        int key = 78;
        //int index = InterpolationSearch.interpolationSearch(arr, key);
        int index = InterpolationSearch.interpolationSearchNoRecursion(arr, key);
        if (index != -1)
            System.out.println(key + " 在数组中的索引为 " + index);
        else
            System.out.println("数组中不存在 " + key);
    }

    @Test
    public void testFibonacciSearch() {
        int key = 66;
        int index = FibonacciSearch.fibonacciSearch(arr,key);
        if (index != -1)
            System.out.println(key + " 在数组中的索引为 " + index);
        else
            System.out.println("数组中不存在 " + key);
    }
}