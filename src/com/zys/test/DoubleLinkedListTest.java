package com.zys.test;

import com.zys.list.linkedlist.DoubleLinkedList;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description: 双向链表测试类
 * @author: Leo
 * @create: 2019-07-26 16:41
 **/
public class DoubleLinkedListTest {
    DoubleLinkedList list;

    @Before
    public void createDoubleLinkedList(){
        list = new DoubleLinkedList();
        list.add(27);
        list.add(37);
        list.add(28);
        list.add(56);
        list.add(45);
    }
    @Test
    public void testAdd(){
        list.add(1,66);
        System.out.println("列表是否为空："+list.isEmpty());
        System.out.println("列表元素个数："+list.size());
        System.out.println(String.format("索引为 %s 的元素：",2)+list.get(2));
        System.out.println("遍历列表元素：");
        list.printList();
    }
    @Test
    public void testRemove(){
        int i = 4;
        System.out.println("删除前：");
        list.printList();
        list.remove(i);
        System.out.println("删除后：");
        list.printList();
    }
}