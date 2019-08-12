package com.zys.queue.looparrayqueue;

import com.zys.queue.MyQueue;

/**
 * @program: dataStructure
 * @description: 自定义循环数组队列
 * @author: Leo
 * @create: 2019-05-15 21:03
 **/
public class MyLoopArrayQueue implements MyQueue {
    //用于存储队列中的元素
    private Object[] elementData;
    //用于存储队列的长度
    private int size;
    //队首索引
    private int front;
    //队尾索引
    private int rear;

    public MyLoopArrayQueue() {
        this(5);
    }

    public MyLoopArrayQueue(int initialCapacity) {
        if (initialCapacity > 0)
            elementData = new Object[initialCapacity];
        else
            elementData = new Object[5];
    }

    /**
     * @Description: 返回队列的大小
     * @return: int
     * @Author: Leo
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @Description: 返回队列是否为空
     * @return: boolean
     * @Author: Leo
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @Description: 元素入队
     * @Param: [e] 将要入队的元素
     * @Author: Leo
     */
    @Override
    public void enqueue(Object e) {
        //数组已满 扩容
        /*if (size == elementData.length){
            elementData = Arrays.copyOf(elementData,elementData.length * 2);
        }*/
        //不可扩容的情况下
        if (size == elementData.length)
            throw new RuntimeException("队列已满！不可继续入队。");
        //队尾入队
        elementData[rear] = e;
        //队尾后移并对数组长度取余
        rear = (rear+1) % elementData.length;
        size++;
    }

    /**
     * @Description: 元素出队
     * @return: java.lang.Object 出队的元素
     * @Author: Leo
     */
    @Override
    public Object dequeue() {
        if (size > 0){
            Object temp = elementData[front];
            front = (front+1) % elementData.length;
            size--;
            return temp;
        }
        return null;
    }

    /**
     * @Description: 得到队首元素
     * @return: java.lang.Object
     * @Author: Leo
     */
    @Override
    public Object peek() {
        if (size > 0)
            return elementData[front];
        return null;
    }
}