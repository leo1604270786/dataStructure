package com.zys.search;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description: 斐波那契查找
 * @author: Leo
 * @create: 2019-08-02 15:08
 **/
public class FibonacciSearch {
    //斐波那契数列大小
    private static final int maxSize = 20;

    /**
     * 斐波那契查找（非递归实现）
     *
     * @param arr 有序数组
     * @param key 待查找的值
     * @return 待查找的值在数组中的索引（不存在返回-1）
     */
    public static int fibonacciSearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        //黄金分割点（斐波那契分割点）下标
        int mid = 0;
        //第一个大于数组长度的斐波那契下标
        int k = 0;
        //获取斐波那契数列
        int[] fibSeq = getFibonacciSeq(maxSize);
        //找到第一个大于数组长度的斐波那契下标
        while (arr.length > fibSeq[k] - 1) {
            k++;
        }
        //斐波那契数列性质：F(k) = F(k-1) + F(k-2)
        //两边同时减去1 =》 F(k)-1 = (F(k-1)-1) + (F(k-2)-1) + 1，其中等式右边最后1表示我们需要找的mid的位置，
        //那么数组被分为 两部分 =》 左：F(k-1)-1 右：F(k-2)-1 从而可以计算出分割点下标=》 mid = left + F(k-1)-1
        //由于fibSeq[k]（斐波那契数列第k项-1） 可能大于数组长度， 所以需要新建一个临时数组，扩容至fibSeq[k]大小
        int[] temp = Arrays.copyOf(arr, fibSeq[k]);
        //将扩容后数组 自动填充的部分用原数组最后一个值填充
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }
        while (left <= right) {
            mid = left + fibSeq[k - 1] - 1;
            if (key > temp[mid]) { //向右查找
                left = mid + 1;
                // F(k) = F(k-1) + F(k-2) ，此时需要向右查找，右边部分长度为F(k-2)
                // 继续分割 =》 F(k-2) = F(k-3) + F(k-4)，即下一次在F(k-4)那部分中继续查找
                k -= 2;
            } else if (key < temp[mid]) { //向左查找
                right = mid - 1;
                // F(k) = F(k-1) + F(k-2) ，此时需要向左查找，左边部分长度为F(k-1)
                // 继续分割 =》 F(k-1) = F(k-2) + F(k-3)，即下一次在F(k-2)那部分中继续查找
                k--;
            } else { //找到了
                //判断mid是在原数组范围内还是扩充后的范围内
                if (mid <= arr.length - 1) { //在原数组范围内
                    return mid;
                } else { //在扩充后的范围内（即为原数组最后一个值，返回数组最后一个索引即可）
                    return arr.length - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 获取斐波那契数列
     *
     * @param size 斐波那契数列大小
     * @return
     */
    private static int[] getFibonacciSeq(int size) {
        if (size <= 0) {
            throw new RuntimeException("斐波那契数列大小 " + size + " 不合法");
        }
        int[] temp = new int[size];
        temp[0] = 1;
        temp[1] = 1;
        for (int i = 2; i < size; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp;
    }
}