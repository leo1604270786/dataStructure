package com.zys.test;

import com.zys.list.linkedlist.CircleSingleLinkedList;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description: 约瑟夫问题测试类
 * @author: Leo
 * @create: 2019-07-28 13:46
 **/
public class JosephusTest {
    CircleSingleLinkedList list;
    @Before
    public void init(){
        list = new CircleSingleLinkedList();
    }
    @Test
    public void test1(){
        list.addBoy(5);
        list.printBoys();
    }
    @Test
    public void test2(){
        list.addBoy(25);
        System.out.println("出圈前序列：");
        list.printBoys();
        System.out.println();
        System.out.println("出圈序列：");
        list.countBoys(1,2,25);
    }
}