package com.zys.search;

/**
 * @program: dataStructure
 * @description: 插值查找（对于数据量较大，关键字分布比较均匀时速度较快）
 * @author: Leo
 * @create: 2019-08-02 14:14
 **/
public class InterpolationSearch {
    /**
     * 插值查找（递归实现）
     *
     * @param arr 有序数组（这里是升序，如果是降序，修改部分比较语句即可）
     * @param key 要查找的值
     * @return 返回查找到的值在数组中的索引（不存在返回-1）
     */
    public static int interpolationSearch(int[] arr, int key) {
        return interpolationSearch(arr, 0, arr.length - 1, key);
    }

    private static int interpolationSearch(int[] arr, int left, int right, int key) {
        //不符合条件，返回-1
        //条件key < arr[left] || key > arr[right]不仅能快速得出key不在数组范围内
        //也防止了在计算中间索引时越界
        if (left > right || key < arr[left] || key > arr[right]) {
            return -1;
        }
        //计算中间索引（和二分查找主要的区别，根据key自适应查找位置）
        int mid = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);
        if (key > arr[mid]) { //向右递归查找
            return interpolationSearch(arr, mid + 1, right, key);
        } else if (key < arr[mid]) { //向左递归查找
            return interpolationSearch(arr, left, mid - 1, key);
        } else { //查找到了，返回索引
            return mid;
        }
    }

    /**
     * 插值查找（非递归实现）
     * @param arr
     * @param key
     * @return
     */
    public static int interpolationSearchNoRecursion(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        //不符合条件，返回-1
        //条件key < arr[left] || key > arr[right]不仅能快速得出key不在数组范围内
        //也防止了在计算中间索引时越界
        if (left > right || key < arr[left] || key > arr[right]) {
            return -1;
        }
        while (left <= right) {
            //计算中间索引（和二分查找主要的区别，根据key自适应查找位置）
            int mid = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);
            if (key > arr[mid]) { //向右查找
                left = mid + 1;
            } else if (key < arr[mid]) { //向左查找
                right = mid - 1;
            } else { //查找到了，返回索引
                return mid;
            }
        }
        return -1;
    }
}