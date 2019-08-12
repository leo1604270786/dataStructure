package com.zys.test;

import com.zys.binarytree.BinaryTree;
import com.zys.binarytree.MyLinkedBinaryTree;
import com.zys.binarytree.TreeNode;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description: MyLinkedBinaryTree测试类
 * @author: Leo
 * @create: 2019-05-16 12:27
 **/
public class MyLinkedBinaryTreeTest {
    private BinaryTree bTree;

    @Before
    public void createTree(){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,node7);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node2 = new TreeNode(2,node3,node6);
        TreeNode node4 = new TreeNode(4,null,node5);
        TreeNode node1 = new TreeNode(1,node4,node2);
        
        bTree = new MyLinkedBinaryTree(node1);
        //bTree = new MyLinkedBinaryTree();

    }
    @Test
    public void testSizeEmpty(){
        System.out.println("二叉树的结点总数："+bTree.size());
        System.out.println("二叉树是否为空："+bTree.isEmpty());
        System.out.println("二叉树的高度为："+bTree.getHeight());
    }
    @Test
    public void testPreOrderTraverse(){
        //先序遍历 1 4 5 2 3 6 7
        bTree.preOrderTraverse();
        bTree.preOrderByStack();
    }
    @Test
    public void testInOrderTraverse(){
        //中序遍历 4 5 1 3 2 6 7
        bTree.inOrderTraverse();
        bTree.inOrderByStack();
    }
    @Test
    public void testPostOrderTraverse(){
        //后序遍历 5 4 3 7 6 2 1
        bTree.postOrderTraverse();
        bTree.postOrderByStack();
        bTree.postOrderByStack2();
    }
    @Test
    public void testFindKey(){
        System.out.println("二叉树中是否存在值为"+1+"的结点：");
        System.out.println(bTree.findKey(1));
        System.out.println("二叉树中是否存在值为"+9+"的结点：");
        System.out.println(bTree.findKey(9));
    }
    @Test
    public void testLevelOrderTraverse(){
        //层次遍历 1 4 2 5 3 6 7
        bTree.levelOrderByQueue();
    }
}