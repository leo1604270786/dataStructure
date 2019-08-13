package com.zys.sort;

/**
 * @program: dataStructure
 * @description: 堆排序
 * @author: Leo
 * @create: 2019-08-13 09:18
 **/
public class HeapSort {

    /**
     * 堆排序思路：
     *  1. 将无序序列调整成一个大顶推
     *  2. 将堆顶元素与末尾元素交换，最大的元素就放在了数组末尾
     *  3. 将剩余元素重新调整成大顶堆，继续与当前末尾元素交换，直到整个序列有序
     */


    /**
     * 堆排序（升序）
     *
     * @param arr 待排序数组
     */
    public static void heapSort(int[] arr) {
        //最后一个非叶子结点索引 = arr.length / 2 - 1
        //1.将无序序列调整成一个大顶堆，从最后一个非叶子结点开始
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            //2. 将堆顶元素与末尾元素交换
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //3. 将剩余元素重新调整成大顶堆，继续与当前末尾元素交换，直到整个序列有序
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 将以i为根的子树调整成一个大顶堆
     *
     * @param arr    待排序数组
     * @param i      非叶子结点索引
     * @param length 调整中需要考虑的元素个数（每次调整并将堆顶元素交换至数组最后，length--）
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        //先保存当前根结点的值
        int currRoot = arr[i];
        //j指向当前子树的根结点（i）的左子结点
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            //找出左右子节点中较大的数
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                //指向当前根结点的右节点
                j++;
            }
            //再将左右子节点中较大的数与当前根结点比较
            //如果比当前根结点的值大
            if (arr[j] > currRoot) {
                //将较大的数赋给当前根结点坐在的位置
                arr[i] = arr[j];
                //将当前根结点指向与之交换的结点
                i = j;
            } else {
                //退出循环
                break;
            }
        }
        //将当前根结点的值赋给之前与之交换的结点（i记录了索引）
        arr[i] = currRoot;
    }
}