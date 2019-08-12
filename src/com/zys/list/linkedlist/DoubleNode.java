package com.zys.list.linkedlist;

/**
 * @program: dataStructure
 * @description: 双链表的节点
 * @author: Leo
 * @create: 2019-07-26 16:22
 **/
public class DoubleNode {
    //用于存储数据
    public Object data;
    //用于存储下一个结点的引用
    public DoubleNode next;
    //用于存储上一个节点的引用
    public DoubleNode pre;

    public DoubleNode() {
    }

    public DoubleNode(Object data) {
        this.data = data;
    }

    public DoubleNode(Object data, DoubleNode next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}