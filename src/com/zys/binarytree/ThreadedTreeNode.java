package com.zys.binarytree;

/**
 * @program: dataStructure
 * @description: 线索二叉树结点
 * @author: Leo
 * @create: 2019-08-08 21:21
 **/
public class ThreadedTreeNode{
    //存储结点数据
    private Object value;
    //左孩子结点
    private ThreadedTreeNode leftChild;
    //右孩子结点
    private ThreadedTreeNode rightChild;
    //当leftTag或rightTag == 0 时， 表示指向的是左（右）子树
    //当leftTag或rightTag == 1 时， 表示指向的是前驱（后继）结点
    private int leftTag;
    private int rightTag;

    public ThreadedTreeNode(Object value) {
        this.value = value;
    }

    public ThreadedTreeNode(Object value, ThreadedTreeNode leftChild, ThreadedTreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ThreadedTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(ThreadedTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public ThreadedTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(ThreadedTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getLeftTag() {
        return leftTag;
    }

    public void setLeftTag(int leftTag) {
        this.leftTag = leftTag;
    }

    public int getRightTag() {
        return rightTag;
    }

    public void setRightTag(int rightTag) {
        this.rightTag = rightTag;
    }

    @Override
    public String toString() {
        return "ThreadedTreeNode{" +
                "value=" + value +
                ", leftTag=" + leftTag +
                ", rightTag=" + rightTag +
                '}';
    }
}