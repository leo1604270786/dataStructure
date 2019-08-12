package com.zys.test;

import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description: 哈希表测试类
 * @author: Leo
 * @create: 2019-08-03 22:35
 **/
public class HashTableTest {
    private HashTable hashTable;

    @Before
    public void init() {
        int size = 7;
        hashTable = new HashTable(size);
    }

    @Test
    public void testAll() {
        Emp emp1 = new Emp(1, "tom");
        Emp emp2 = new Emp(2, "jack");
        Emp emp3 = new Emp(8, "rose");
        hashTable.add(emp1);
        hashTable.add(emp2);
        hashTable.add(emp3);
        hashTable.list();

        hashTable.findEmpById(8);
        //hashTable.findEmpById(3);
        //hashTable.findEmpById(-1);

        hashTable.deleteEmpById(1);
        hashTable.deleteEmpById(2);
        hashTable.deleteEmpById(8);
        hashTable.list();
    }
}

//哈希表
class HashTable {
    //存放链表的数组
    private EmpLinkedList[] empLinkedLists;
    //哈希表大小
    private int size;

    public HashTable(int size) {
        if (size <= 0) {
            throw new RuntimeException("哈希表大小不合法！");
        }
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        //初始化每条链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员到哈希表
     *
     * @param emp
     */
    public void add(Emp emp) {
        //先根据雇员id计算该放入哪条链表，即调用哈希函数
        int hashCode = hash(emp.id);
        //放入对应链表
        empLinkedLists[hashCode].add(emp);
    }

    /**
     * 通过id查找雇员
     *
     * @param id
     * @return
     */
    public void findEmpById(int id) {
        //根据id获取hashCode，从而得知在哪条链表里
        int hashCode = hash(id);
        Emp emp = empLinkedLists[hashCode].findEmpById(id);
        //找到了
        if (emp != null) {
            System.out.println("id = " + id + " 的雇员在第 " + (hashCode + 1) + "条链表中");
        } else {
            System.out.println("id = " + id + "的雇员不在哈希表中！");
        }
    }

    /**
     * 根据id删除雇员
     * @param id
     */
    public void deleteEmpById(int id) {
        //根据id获取hashCode，从而得知在哪条链表里
        int hashCode = hash(id);
        boolean delete = empLinkedLists[hashCode].deleteEmpById(id);
        if (delete) {
            System.out.println("id = " + id + " 的雇员删除成功!");
        } else {
            System.out.println("id = " + id + " 的雇员删除失败!");
        }
    }

    /**
     * 打印哈希表中所有信息
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    /**
     * 哈希函数（取模法）
     *
     * @param id
     * @return
     */
    public int hash(int id) {
        return Math.abs(id) % size;
    }
}

//雇员信息
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
//节点为雇员的链表

class EmpLinkedList {
    //头指针，指向第一个有效雇员信息
    private Emp head;

    /**
     * 添加雇员到链表末尾
     *
     * @param emp
     */
    public void add(Emp emp) {
        //链表为空
        if (head == null) {
            head = emp;
        } else {
            Emp curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = emp;
        }
    }

    /**
     * 通过id查找雇员
     *
     * @param id
     * @return
     */
    public Emp findEmpById(int id) {
        if (head == null) {
            return null;
        }
        Emp curr = head;
        while (curr != null) {
            if (curr.id == id) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     * 通过id删除雇员
     *
     * @param id
     * @return 删除是否成功
     */
    public boolean deleteEmpById(int id) {
        if (head == null) {
            return false;
        }
        Emp curr = head;
        if (curr.id == id) {
            head = head.next;
            return true;
        }
        while (curr.next != null) {
            if (curr.next.id == id) {
                curr.next = curr.next.next;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * 遍历链表
     *
     * @param no 当前链表编号（方便直观查看）
     */
    public void list(int no) {
        //链表为空
        if (head == null) {
            System.out.println("第 " + (no + 1) + " 条链表为空");
        } else {
            Emp curr = head;
            System.out.print("第 " + (no + 1) + " 条链表内容： ");
            while (curr != null) {
                System.out.print(" => id = " + curr.id + ", name = " + curr.name + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }
}