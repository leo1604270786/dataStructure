package com.zys.stack.linkedstack;

import com.zys.stack.MyStack;

/**
 * @program: dataStructure
 * @description: 链栈
 * @author: Leo
 * @create: 2019-07-28 14:52
 **/
public class MyLinkedStack implements MyStack {
    //链栈头节点
    private LinkedStackNode head = new LinkedStackNode();
    //栈顶指针
    private LinkedStackNode top;
    //栈中元素个数
    private int size;
    public MyLinkedStack(){
        top = head.next;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(Object e) {
        if (e instanceof LinkedStackNode){
            LinkedStackNode p = (LinkedStackNode) e;
            p.next = top;
            head.next = p;
            top = p;
            size++;
        }else {
            System.out.println("栈节点类型错误");
        }
    }

    @Override
    public Object pop() {
        if (isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        LinkedStackNode val = top;
        //出栈
        head.next = top.next;
        top = head.next;
        size--;
        return val;
    }

    @Override
    public Object peek() {
        return top;
    }
}
