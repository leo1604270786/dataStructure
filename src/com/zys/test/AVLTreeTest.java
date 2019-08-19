package com.zys.test;

import com.zys.binarytree.AVLTree;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description:
 * @author: Leo
 * @create: 2019-08-19 16:52
 **/
public class AVLTreeTest {

    private AVLTree avlTree;

    @Before
    public void init() {
        avlTree = new AVLTree();
    }

    @Test
    public void testGetHeight() {
        int[] arr = new int[]{4, 3, 6, 5, 7, 8};
        avlTree.create(arr);
        System.out.println("AVL树的高度为：" + avlTree.getHeight());
    }
}