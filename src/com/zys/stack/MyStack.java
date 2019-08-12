package com.zys.stack;

/**
 * @program: dataStructure
 * @description: 自定义一个栈接口
 * @author: Leo
 * @create: 2019-05-15 20:12
 **/
public interface MyStack {
    /**
    * @Description: 返回栈的大小
    * @return: int
    * @Author: Leo
    */
    int size();
    /**
    * @Description: 返回栈是否为空
    * @return: boolean
    * @Author: Leo
    */
    boolean isEmpty();
    /**
    * @Description: 元素入栈
    * @Param: [e] 将要入栈的元素
    * @Author: Leo
    */
    void push(Object e);
    /**
    * @Description: 元素出栈
    * @return: java.lang.Object 出栈的元素
    * @Author: Leo
    */
    Object pop();
    /**
    * @Description: 得到栈顶元素
    * @return: java.lang.Object
    * @Author: Leo
    */
    Object peek();
}