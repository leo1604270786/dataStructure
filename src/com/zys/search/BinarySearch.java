package com.zys.search;

/**
 * @program: dataStructure
 * @description: 折半查找（二分查找）
 * @author: Leo
 * @create: 2019-05-16 17:26
 **/
public class BinarySearch {
    /**
     * 二分查找（非递归实现）
     * @Description: 返回key在arr中的索引 不存在则返回-1
     * @Param: [arr, key] 数组必须有序
     * @return: int
     * @Author: Leo
     */
    public static int binarySearchNoRecursion(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            //int mid = (low + high) / 2;
            int mid = low + (high - low) / 2;//防溢出
            if (key == arr[mid]){
                return mid;
            }else if (key < arr[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找（递归实现）
     * @Description: 返回key在arry中的索引 不存在则返回-1
     * @Param: [arr, key] 数组必须有序
     * @return: int
     * @Author: Leo
     */
    public static int binarySearch(int[] arr, int key) {
        return binarySearch(arr, key, 0, arr.length - 1);
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {
        if (low > high)
            return -1;
        //int mid = (low + high) / 2;
        int mid = low + (high - low) / 2;//防溢出
        if (key == arr[mid]) {
            return mid;
        } else if (key < arr[mid]) {
            return binarySearch(arr, key, low, mid - 1);
        } else {//key > arr[mid]
            return binarySearch(arr, key, mid + 1, high);
        }
    }
}