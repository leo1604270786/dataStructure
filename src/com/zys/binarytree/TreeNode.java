package com.zys.binarytree;

/**
 * @program: dataStructure
 * @description: 二叉树结点
 * @author: Leo
 * @create: 2019-05-16 11:44
 **/
public class TreeNode {
    //存储结点数据
    public Integer value;
    //左孩子结点
    public TreeNode leftChild;
    //右孩子结点
    public TreeNode rightChild;

    public TreeNode(Integer value) {
        this.value = value;
    }

    public TreeNode(Integer value, TreeNode leftChild, TreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}