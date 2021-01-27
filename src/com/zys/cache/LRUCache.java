package com.zys.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU算法实现
 * 全称 Least Recently Used，意为最近最少使用，是最常见的页面置换算法，也常用于实现缓存淘汰策略。
 * 思路：哈希表 + 双向链表。链表头节点代表最近使用过的数据。
 *
 * 对于 get 操作，首先判断 key 是否存在：
 *
 * - 如果 key 不存在，则返回 -1；
 * - 如果 key 存在，则 key 对应的节点是最近被使用的节点。通过哈希表定位到该节点在双向链表中的位置，并将其移动到双向链表的头部，最后返回该节点的值。
 *
 * 对于 put 操作，首先判断 key 是否存在：
 *
 * - 如果 key 不存在，使用 key 和 value 创建一个新的节点，在双向链表的头部添加该节点，并将 key 和该节点添加进哈希表中。然后判断双向链表的节点数是否超出容量，如果超出容量，则删除双向链表的尾部节点，并删除哈希表中对应的项；
 * - 如果 key 存在，则与 get 操作类似，先通过哈希表定位，再将对应的节点的值更新为 value，并将该节点移到双向链表的头部。
 *
 * @author Leo
 * @create 2021/1/27 9:45
 **/
public class LRUCache {
    // 双向链表节点
    static class MyLinkedNode {
        private int key;
        private int value;
        MyLinkedNode prev;
        MyLinkedNode next;

        MyLinkedNode() {}
        MyLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    // Map，用于定位指定key的节点在链表中的位置
    private Map<Integer, MyLinkedNode> cache;
    // 头、尾节点
    private MyLinkedNode head, tail;
    // 实际元素个数
    private int size;
    // 容量
    private int capacity;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new MyLinkedNode();
        tail = new MyLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 先获取到对应节点
        MyLinkedNode node = cache.get(key);
        // 不存在
        if(node == null) {
            return -1;
        }
        // 先删除链表中的该节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 将其放到链表头部，表示最近使用的元素
        move2head(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 先获取对应节点
        MyLinkedNode node = cache.get(key);
        // 不存在
        if(node == null) {
            // 新建节点
            MyLinkedNode newNode = new MyLinkedNode(key, value);
            // 放入Map
            cache.put(key, newNode);
            size++;
            // 判断是否到达上限
            if(size > capacity) {
                // 先删除最久未使用的数据，即链表尾部
                MyLinkedNode n = tail.prev;
                n.prev.next = tail;
                tail.prev = n.prev;
                cache.remove(n.key);
                size--;
            }
            // 放入链表头部
            move2head(newNode);
        } else { // 存在
            // 更新值
            node.value = value;
            // 先删除链表中的该节点
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // 放到链表头部
            move2head(node);
        }
    }

    private void move2head(MyLinkedNode node) {
        //放到头部
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}