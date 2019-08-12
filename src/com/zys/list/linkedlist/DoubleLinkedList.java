package com.zys.list.linkedlist;

import com.zys.list.MyList;

/**
 * @program: dataStructure
 * @description: 双向链表
 * @author: Leo
 * @create: 2019-07-26 16:24
 **/
public class DoubleLinkedList implements MyList {

    //头结点 不存储数据
    public DoubleNode head;
    //链表中元素的个数
    private int size;

    public DoubleLinkedList(){
        head = new DoubleNode();
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i <= 0 || i > size){
            throw new RuntimeException("索引 i=" + i + " 越界！无法取出数据！");
        }
        DoubleNode cur = head.next;
        for(int j = 0; j < i; j++){
            cur = cur.next;
        }
        return cur.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(Object element) {
        add(size,element);
    }

    @Override
    public void add(int index, Object element) {
        //index越界,正确范围 [0,size]
        if (index < 0 || index > size)
            throw new RuntimeException(String.format("索引index = %s 越界!",index));
        DoubleNode p = head;
        //new 一个结点对象
        DoubleNode newNode = new DoubleNode(element);
        //找到index的前一个
        for(int i = 0; i < index; i++)
            p = p.next;
        if (p.next != null){
            p.next.pre = newNode;
        }
        newNode.pre = p;
        newNode.next = p.next;
        p.next = newNode;
        //元素个数++
        size++;
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) {
        //i越界 正确范围 [0,size-1]
        if (i < 0 || i >= size)
            throw new RuntimeException(String.format("索引 %s 越界！",i));
        DoubleNode p = head.next;
        //找到i
        for (int j = 0; j < i; j++)
            p = p.next;
        p.pre.next = p.next;
        if (p.next != null){
            p.next.pre = p.pre;
        }
        //元素个数--
        size--;
        return p.data;
    }

    @Override
    public boolean remove(Object e) {
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }

    /**
     * 打印链表
     */
    public void printList(){
        DoubleNode cur = head.next;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}