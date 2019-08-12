package com.zys.stack.arraystack;

import com.zys.stack.MyStack;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description: 自定义的顺序栈
 * @author: Leo
 * @create: 2019-05-15 20:28
 **/
public class MyArrayStack implements MyStack {
    //用于存储栈中的元素
    private Object[] elementData;
    //栈中元素的个数
    private int size;

    public MyArrayStack() {
        this(5);
    }
    public MyArrayStack(int initialCapacity) {
        if (initialCapacity > 0){
            //给数组分配内存
            elementData = new Object[initialCapacity];
        }
        //给定初始值不合法
        else {
            elementData = new Object[5];
        }
    }
    /**
     * @Description: 返回栈的大小
     * @return: int
     * @Author: Leo
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @Description: 返回栈是否为空
     * @return: boolean
     * @Author: Leo
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param e
     * @Description: 元素入栈
     * @Param: [e] 将要入栈的元素
     * @Author: Leo
     */
    @Override
    public void push(Object e) {
        //数组满了，扩容 扩大一倍
        if (size == elementData.length){
            elementData = Arrays.copyOf(elementData,elementData.length * 2);
        }
        //往栈顶添加元素
        elementData[size++] = e;
    }

    /**
     * @Description: 元素出栈
     * @return: java.lang.Object 出栈的元素
     * @Author: Leo
     */
    @Override
    public Object pop() {
        if (size > 0)
            return elementData[--size];
        return null;
    }

    /**
     * @Description: 得到栈顶元素
     * @return: java.lang.Object
     * @Author: Leo
     */
    @Override
    public Object peek() {
        if (size > 0)
            return elementData[size-1];
        return null;
    }

    /**
     * 遍历栈
     */
    public void printStack(){
        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }
        //遍历
        for (int i = size; i > 0; i--){
            System.out.print(elementData[i] + " ");
        }
    }
}