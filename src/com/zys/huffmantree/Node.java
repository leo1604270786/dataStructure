package com.zys.huffmantree;

/**
 * @program: dataStructure
 * @description: 哈夫曼树节点
 * @author: Leo
 * @create: 2019-08-18 16:54
 **/
public class Node implements Comparable<Node>{
    //节点权值
    public int value;
    //节点数据
    public Character ch;
    //左指针
    public Node left;
    //右指针
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Character ch) {
        this.value = value;
        this.ch = ch;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", ch=" + ch +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}