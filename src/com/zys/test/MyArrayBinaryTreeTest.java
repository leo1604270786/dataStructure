package com.zys.test;

import com.zys.binarytree.MyArrayBinaryTree;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description:
 * @author: Leo
 * @create: 2019-08-07 23:15
 **/
public class MyArrayBinaryTreeTest {

    private MyArrayBinaryTree binaryTree;

    @Before
    public void init() {
        binaryTree = new MyArrayBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public void testPreOrder(){
        System.out.println("前序遍历：");
        binaryTree.preOrderTraverse();
    }

    @Test
    public void testInOrder(){
        System.out.println("中序遍历：");
        binaryTree.inOrderTraverse();
    }

    @Test
    public void testPostOrder(){
        System.out.println("后序遍历：");
        binaryTree.postOrderTraverse();
    }
}