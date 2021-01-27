package com.zys.heap;

/**
 * 堆（大顶堆）
 *
 * @author Leo
 * @create 2021/1/26 17:11
 **/
public class Heap {
    //堆数组
    private int[] nums;
    //堆大小
    private int size;

    public Heap() {
        //默认大小
        size = 11;
        nums = new int[size];
    }

    public Heap(int size) {
        this.size = size;
        nums = new int[size];
    }

    public Heap(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
    }

    /**
     * 下沉
     * @param k
     */
    private void siftDown(int k) {
        //保存当前结点的值
        int curr = nums[k];
        //指向左子节点(2 * k + 1)
        for(int i = 2 * k + 1; i < size; i = 2 * i + 1) {
            //找出左右子节点较大的那个
            if(i + 1 < size && nums[i+1] > nums[i]) {
                //右子节点大，i赋值为右子节点索引
                i = i + 1;
            }
            //和当前结点进行比较
            if(nums[i] <= curr) {
                //子节点 <= 当前结点，当前结点不需要下沉
                break;
            }
            //交换根结点 和 左右子节点中较大的那个
            swap(i, k);
            //更新当前结点索引，继续比较
            k = i;
        }
    }

    /**
     * 上浮
     * @param k
     */
    private void siftUp(int k) {
        //保存当前结点的值
        int curr = nums[k];
        //指向父节点(k / 2)
        for (int i = k / 2; k > 1; k /= 2) {
            //和当前结点进行比较
            if(nums[i] >= curr) {
                //父节点 >= 当前结点，当前结点不需要上浮
                break;
            }
            //交换父节点和当前结点
            swap(i, k);
        }
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 堆排序
     */
    public void heapSort() {
        //构造堆（从最后一个非叶子结点开始）
        for(int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }

        while (size > 1){
            //将根结点（最大值），放到数组最后面，并减小堆大小，代表其已经在堆外
            swap(0, --size);
            //下沉调整堆
            siftDown(0);
        }
    }
}
