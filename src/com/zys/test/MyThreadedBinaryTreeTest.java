package com.zys.test;

import com.zys.binarytree.MyThreadedBinaryTree;
import com.zys.binarytree.ThreadedTreeNode;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description:
 * @author: Leo
 * @create: 2019-08-08 21:19
 **/
public class MyThreadedBinaryTreeTest {
    private MyThreadedBinaryTree binaryTree;
    private ThreadedTreeNode root;
    private ThreadedTreeNode node1;
    private ThreadedTreeNode node2;
    private ThreadedTreeNode node3;
    private ThreadedTreeNode node4;
    private ThreadedTreeNode node5;
    @Before
    public void init(){
        root = new ThreadedTreeNode(1);
        node1 = new ThreadedTreeNode(3);
        node2 = new ThreadedTreeNode(6);
        node3 = new ThreadedTreeNode(8);
        node4 = new ThreadedTreeNode(10);
        node5 = new ThreadedTreeNode(14);

        root.setLeftChild(node1);
        root.setRightChild(node2);

        node1.setLeftChild(node3);
        node1.setRightChild(node4);

        node2.setLeftChild(node5);
        binaryTree = new MyThreadedBinaryTree(root);
    }

    @Test
    public void testThreadedBinaryTree(){
        binaryTree.threadedNode();
        System.out.println("线索化二叉树后： node4的左指针指向："+node4.getLeftChild());
        System.out.println("线索化二叉树后： node4的右指针指向："+node4.getRightChild());

        System.out.println("中序遍历线索化二叉树：");
        binaryTree.inOrderTraverse();
    }
}