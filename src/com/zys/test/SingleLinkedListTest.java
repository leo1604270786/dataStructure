package com.zys.test;

import com.zys.list.linkedlist.Node;
import com.zys.list.linkedlist.SingleLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: dataStructure
 * @description: SingleLinkedList测试类
 * @author: Leo
 * @create: 2019-05-15 18:08
 **/
public class SingleLinkedListTest {
    SingleLinkedList list;
    @Before
    public void createSingleLinkedList(){
        list = new SingleLinkedList();
        list.add(27);
        list.add(37);
        list.add(28);
        list.add(56);
        list.add(45);
    }
    @Test
    public void testAdd(){
        list.add(5,new Integer(66));

        //System.out.println("列表是否为空："+list.isEmpty());
        System.out.println("列表元素个数："+list.size());
        System.out.println(String.format("索引为 %s 的元素：",2)+list.get(2));
        System.out.println("遍历列表元素：");
        System.out.println(list.toString());
    }
    @Test
    public void testContains(){
        System.out.println(String.format("链表中是否存在 %s ：",8)+list.contains(Integer.valueOf(8)));
        System.out.println(String.format("链表中是否存在 %s ：",56)+list.contains(Integer.valueOf(56)));
        System.out.println("遍历列表元素：");
        System.out.println(list.toString());
    }
    @Test
    public void testAddBeforeAndAfter(){
        System.out.println("遍历列表元素：");
        System.out.println(list.toString());

        //list.addBefore(Integer.valueOf(28),new Integer(99));
        list.addBefore(Integer.valueOf(27),new Integer(99));

        list.addAfter(Integer.valueOf(45),new Integer(77));
        System.out.println("遍历列表元素：");
        System.out.println(list.toString());
    }
    @Test
    public void testRemove(){
        System.out.println("遍历列表元素：");
        System.out.println(list.toString());

        System.out.println("被删除的元素："+list.remove(4));
        list.remove(Integer.valueOf(37));

        System.out.println("遍历列表元素：");
        System.out.println(list.toString());
    }
    @Test
    public void testReplace(){
        System.out.println("遍历列表元素：");
        System.out.println(list.toString());

        System.out.println("被替换的元素："+list.replace(2,new Integer(55)));

        System.out.println("遍历列表元素：");
        System.out.println(list.toString());
    }
    @Test
    public void testFindLastIndexOfNode(){
        //得出单链表的倒数第k个结点
        int k = 2;
        //获取总长度
        int len = list.size();
        if (k <= 0 || k > len){
            System.out.println("索引k不合法！");
            return;
        }
        Node p = list.head;
        //遍历链表，取出倒数第k个结点
        for (int i = 0; i <= len - k && p != null; i++){
            p = p.getNext();
        }
        System.out.println("倒数第" + k +" 个节点为=" + p.getData());
        System.out.println(list);
    }
    @Test
    public void testReverseList(){
        System.out.println("反转前的链表：");
        System.out.println(list);
        Node head = list.head;
        //没有元素或只有一个元素
        if (head.next == null || head.next.next == null){
            return;
        }
        Node p = head.next;
        //反转后的头结点
        Node reverseHead = new Node();
        while (p != null){
            Node temp = p.next;
            p.next = reverseHead.next;
            reverseHead.next = p;
            p = temp;
        }
        head.next = reverseHead.next;
        System.out.println("反转后的链表：");
        System.out.println(list);
    }
    @Test
    public void testPrintReverseList(){
        System.out.println("正序打印单链表：");
        System.out.println(list);
        //逆序打印链表
        Node head = list.head;
        //声明一个栈
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        System.out.println("逆序打印单链表：");
        while (!stack.isEmpty()){
            System.out.print(stack.pop().data + " ");
        }
        System.out.println();
    }
    @Test
    public void testMergeSortedList(){
        //创建两个有序的单链表
        SingleLinkedList s1 = new SingleLinkedList();
        SingleLinkedList s2 = new SingleLinkedList();

        s1.add(15);
        s1.add(27);
        s1.add(38);
        s1.add(57);

        s2.add(12);
        s2.add(18);
        s2.add(29);
        s2.add(34);
        s2.add(46);
        System.out.println("合并前：");
        System.out.println("s1:");
        printLinkedList(s1);
        System.out.println("s2:");
        printLinkedList(s2);
        SingleLinkedList mergedList = mergeSortedList(s1, s2);
        System.out.println("合并后的链表: ");
        printLinkedList(mergedList);
        System.out.println("合并后：");
        System.out.println("s1:");
        printLinkedList(s1);
        System.out.println("s2:");
        printLinkedList(s2);
    }

    private SingleLinkedList mergeSortedList(SingleLinkedList s1, SingleLinkedList s2){
        //新建一个链表
        SingleLinkedList result = new SingleLinkedList();
        Node head = result.head;
        Node head1 = s1.head;
        Node head2 = s2.head;
        //有一个链表为空
        if (head1.next == null){
            return s2;
        }else if(head2.next == null){
            return s1;
        }
        //都不为空
        Node cur = head;
        Node cur1 = head1.next;
        Node cur2 = head2.next;
        while (cur1 != null && cur2 != null){
            if ((Integer)cur1.data < (Integer) cur2.data){
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        //将未遍历完的链表接到新链表末尾
        if (cur1 != null){
            cur.next = cur1;
        }else {
            cur.next = cur2;
        }
        return result;
    }

    private void printLinkedList(SingleLinkedList s){
        Node cur = s.head.next;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}