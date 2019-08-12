package com.zys.list.linkedlist;

/**
 * @program: dataStructure
 * @description: 单链表结点
 * @author: Leo
 * @create: 2019-05-15 16:51
 **/
public class Node {
    //用于存储数据
    public Object data;
    //用于存储下一个结点的引用
    public Node next;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}