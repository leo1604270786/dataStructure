package com.zys.list.linkedlist;

import com.zys.list.MyList;

/**
 * @program: dataStructure
 * @description: 自己实现的单链表
 * @author: Leo
 * @create: 2019-05-15 17:55
 **/
public class SingleLinkedList implements MyList {
    //头结点 不存储数据
    public Node head;
    //链表中元素的个数
    private int size;

    public SingleLinkedList() {
        head = new Node();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        //索引越界
        if(i < 0 || i >= size){
            throw new RuntimeException(String.format("索引i = %s 越界！",i));
        }
        Node p = head;
        //找到i
        for(int j = 0; j <= i; j++)
            p = p.getNext();
        return p.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        /*Node p = head.getNext();
        for (int i = 0; i < size; i++){
            if(p.getData() == e)
                return true;
            p = p.getNext();
        }
        return false;*/
        return indexOf(e) != -1;
    }

    @Override
    public int indexOf(Object e) {
        Node p = head.getNext();
        for (int i = 0; i < size; i++){
            if(p.getData() == e)
                return i;
            p = p.getNext();
        }
        return -1;
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
        Node p = head;
        //new 一个结点对象
        Node newNode = new Node(element);
        //找到index的前一个
        for(int i = 0; i < index; i++)
            p = p.getNext();
        newNode.setNext(p.getNext());
        p.setNext(newNode);
        //元素个数++
        size++;
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        int i;
        if((i = indexOf(obj)) != -1){
            add(i,e);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        int i;
        if((i = indexOf(obj)) != -1){
            add(i+1,e);
            return true;
        }
        return false;
    }

    @Override
    public Object remove(int i) {
        //i越界 正确范围 [0,size-1]
        if (i < 0 || i >= size)
            throw new RuntimeException(String.format("索引 %s 越界！",i));
        Node p = head;
        Node curr = p;
        //找到i的前一个
        for (int j = 0; j < i; j++)
            p = p.getNext();
        curr = p.getNext();
        p.setNext(curr.getNext());
        curr.setNext(null);
        //元素个数--
        size--;
        return curr.getData();
    }

    @Override
    public boolean remove(Object e) {
        int i;
        if ((i = indexOf(e)) != -1){
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        //i越界 正确范围 [0,size-1]
        if (i < 0 || i >= size)
            throw new RuntimeException(String.format("索引 %s 越界！",i));
        Node p = head;
        //找到i
        for(int j = 0; j <= i; j++)
            p = p.getNext();
        Object replacedData = p.getData();
        p.setData(e);
        return replacedData;
    }
    @Override
    public String toString() {
        //为空
        if (isEmpty())
            return "[]";
        StringBuilder builder = new StringBuilder("[");
        //指向第一个存数据的结点
        Node p = head.getNext();
        for (int i = 0; i < size; i++){
            if(i == size - 1)
                builder.append(p.getData());
            else
                builder.append(p.getData()+",");
            //指向下一个结点
            p = p.getNext();
        }
        builder.append("]");
        return builder.toString();
    }
}