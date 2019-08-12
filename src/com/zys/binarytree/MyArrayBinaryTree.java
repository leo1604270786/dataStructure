package com.zys.binarytree;

/**
 * @program: dataStructure
 * @description: 顺序存储二叉树(一般只考虑完全二叉树)
 * @author: Leo
 * @create: 2019-08-07 22:54
 **/
public class MyArrayBinaryTree implements BinaryTree {
    /**
     * 顺序存储二叉树的特点：
     *  1.第n个结点的左子结点下标为 2*n+1
     *  2.第n个结点的左子结点下标为 2*n+2
     *  3.第n个结点的父结点为下表为 (n-1)/2
     */

    //存储二叉树结点
    private Object[] data;

    public MyArrayBinaryTree(Object[] data) {
        this.data = data;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public TreeNode findKey(Object value) {
        return null;
    }

    private void preOrderTraverse(int index) {
        //打印当前结点
        System.out.print(data[index] + " ");
        //向左递归前序遍历
        if ((index * 2 + 1) < data.length) {
            preOrderTraverse(index * 2 + 1);
        }
        //向右递归前序遍历
        if ((index * 2 + 2) < data.length) {
            preOrderTraverse(index * 2 + 2);
        }
    }

    @Override
    public void preOrderTraverse() {
        if (data == null || data.length == 0) {
            System.out.println("数组为空，不能进行前序遍历。");
            return;
        }
        preOrderTraverse(0);
    }

    private void inOrderTraverse(int index) {
        //向左递归中序遍历
        if ((index * 2 + 1) < data.length) {
            inOrderTraverse(index * 2 + 1);
        }
        //打印当前结点
        System.out.print(data[index] + " ");
        //向右递归中序遍历
        if ((index * 2 + 2) < data.length) {
            inOrderTraverse(index * 2 + 2);
        }
    }
    @Override
    public void inOrderTraverse() {
        if (data == null || data.length == 0) {
            System.out.println("数组为空，不能进行前序遍历。");
            return;
        }
        inOrderTraverse(0);
    }

    private void postOrderTraverse(int index) {
        //向左递归后序遍历
        if ((index * 2 + 1) < data.length) {
            postOrderTraverse(index * 2 + 1);
        }
        //向右递归后序遍历
        if ((index * 2 + 2) < data.length) {
            postOrderTraverse(index * 2 + 2);
        }
        //打印当前结点
        System.out.print(data[index] + " ");
    }

    @Override
    public void postOrderTraverse() {
        if (data == null || data.length == 0) {
            System.out.println("数组为空，不能进行前序遍历。");
            return;
        }
        postOrderTraverse(0);
    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void inOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public void postOrderByStack2() {

    }

    @Override
    public void levelOrderByQueue() {

    }
}