package com.zys.test;

import com.zys.stack.linkedstack.LinkedStackNode;
import com.zys.stack.linkedstack.MyLinkedStack;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description: 链栈测试类
 * @author: Leo
 * @create: 2019-07-28 15:06
 **/
public class MyLinkedStackTest {
    MyLinkedStack stack;

    @Before
    public void init() {
        stack = new MyLinkedStack();
    }

    @Test
    public void testPush() {
        stack.push(new LinkedStackNode(22));
        stack.push(new LinkedStackNode(29));
        stack.push(new LinkedStackNode(74));
        stack.push(new LinkedStackNode(51));
        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println("栈中元素的个数：" + stack.size());
        printMyStack();
        System.out.println("栈是否为空：" + stack.isEmpty());
    }

    public void printMyStack() {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(((LinkedStackNode) stack.pop()).data + " ");
        }
        System.out.println();
    }

    @Test
    public void testPeek() {
        stack.push(new LinkedStackNode(22));
        stack.push(new LinkedStackNode(29));
        System.out.println("栈顶元素为：" + ((LinkedStackNode) stack.peek()).data);
        stack.pop();
        System.out.println("栈顶元素为：" + ((LinkedStackNode) stack.peek()).data);
    }
}