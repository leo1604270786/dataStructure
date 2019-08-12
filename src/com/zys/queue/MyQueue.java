package com.zys.queue;

/**
 * @program: dataStructure
 * @description: 自定义队列接口
 * @author: Leo
 * @create: 2019-05-15 20:59
 **/
public interface MyQueue {
    /**
     * @Description: 返回队列的大小
     * @return: int
     * @Author: Leo
     */
    int size();
    /**
     * @Description: 返回队列是否为空
     * @return: boolean
     * @Author: Leo
     */
    boolean isEmpty();
    /**
     * @Description: 元素入队
     * @Param: [e] 将要入队的元素
     * @Author: Leo
     */
    void enqueue(Object e);
    /**
     * @Description: 元素出队
     * @return: java.lang.Object 出队的元素
     * @Author: Leo
     */
    Object dequeue();
    /**
     * @Description: 得到队首元素
     * @return: java.lang.Object
     * @Author: Leo
     */
    Object peek();
}