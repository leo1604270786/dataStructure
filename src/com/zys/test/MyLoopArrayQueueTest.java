package com.zys.test;

import com.zys.queue.MyQueue;
import com.zys.queue.looparrayqueue.MyLoopArrayQueue;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description: MyLoopArrayQueue测试类
 * @author: Leo
 * @create: 2019-05-15 21:21
 **/
public class MyLoopArrayQueueTest {
    private MyQueue queue;
    @Before
    public void createQueue(){
        //默认大小为5  （不会自动扩容）
        queue = new MyLoopArrayQueue();
    }
    @Test
    public void testEnqueue(){
        queue.enqueue(55);
        queue.enqueue(47);
        queue.enqueue(28);
        queue.enqueue(18);
        queue.enqueue(32);
        System.out.println("队列长度："+queue.size());
        System.out.println("队首元素："+queue.peek());

        System.out.println("出队元素："+queue.dequeue());
        printMyQueue();
    }
    public void printMyQueue(){
        int size = queue.size();
        for (int i = 0; i < size; i++){
            System.out.print(queue.dequeue()+" ");
        }
        System.out.println();
    }
}