package com.zys.list.linkedlist;

/**
 * @program: dataStructure
 * @description: 单向循环链表
 * @author: Leo
 * @create: 2019-07-28 13:29
 **/
public class CircleSingleLinkedList {
    //第一个节点
    public Boy first;

    /**
     *  创建单向循环链表
     * @param nums 小孩个数
     */
    public void addBoy(int nums){
        //校验数据
        if (nums < 1){
            System.out.println("小海个数至少为1");
            return;
        }
        Boy cur = new Boy();
        //创建单向循环链表
        for (int i = 1; i <= nums; i++){
            Boy boy = new Boy(i);
            //第一个小孩
            if (i == 1){
                first = boy;
                first.next = first;
                cur = first;
            }else {
                cur.next = boy;
                boy.next = first;
                cur = boy;
            }
        }
    }

    /**
     * 打印单向环形链表
     */
    public void printBoys(){
        if (first == null){
            System.out.println("链表为空！");
            return;
        }
        Boy cur = first;
        do{
            System.out.print(cur.no + " ");
            cur = cur.next;
        }while (cur != first);
    }

    /**
     * 得到出圈序列
     * @param startNo 开始编号
     * @param countNum 数几下
     * @param nums 初始总人数
     */
    public void countBoys(int startNo, int countNum, int nums){
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("参数不合法！");
            return;
        }
        //初始化辅助指针 指向链表尾部
        Boy helper = first;
        while (helper.next != first){
            helper = helper.next;
        }
        //移动到报数初始位置
        for (int i = 0; i < startNo - 1; i++){
            first = first.next;
            helper = helper.next;
        }
        //得到出圈序列
        while (helper != first){
            //helper指向出圈前一个节点，first指向出圈节点
            for (int i = 0; i < countNum - 1; i++){
                first = first.next;
                helper = helper.next;
            }
            //打印出圈小孩编号
            System.out.print(first.no + " ");
            //出圈
            first = first.next;
            helper.next = first;
        }
        System.out.println();
        System.out.println("圈中最后一个小孩编号：" + helper.no);
    }
}

class Boy{
    //编号
    public int no;
    //指向以一个元素
    public Boy next;

    public Boy(){}
    public Boy(int no){
        this.no = no;
    }
}