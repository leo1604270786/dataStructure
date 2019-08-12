package com.zys.stack.linkedstack;

/**
 * @program: dataStructure
 * @description: 链栈节点
 * @author: Leo
 * @create: 2019-07-28 15:13
 **/
public class LinkedStackNode {
    //数据
    public Object data;
    //指向下一个节点
    public LinkedStackNode next;
    public LinkedStackNode(){

    }
    public LinkedStackNode(Object data){
        this.data = data;
    }
}