package com.zys.test;

import com.zys.binarytree.BinarySortTree;
import com.zys.binarytree.TreeNode;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description:
 * @author: Leo
 * @create: 2019-08-19 14:35
 **/
public class BinarySortTreeTest {

    private BinarySortTree binarySortTree;

    @Before
    public void init() {
        binarySortTree = new BinarySortTree();
    }

    @Test
    public void testAdd() {
        int[] nums = new int[]{7, 3, 10, 12, 5, 1, 9, 2};
        for (int i = 0; i < nums.length; i++) {
            binarySortTree.add(new TreeNode(nums[i]));
        }
        System.out.println("中序遍历二叉排序树：");
        binarySortTree.inOrder();
    }

    @Test
    public void testCreate(){
        int[] nums = new int[]{7, 3, 10, 12, 5, 1, 9, 2};
        binarySortTree.create(nums);
        System.out.println("中序遍历二叉排序树：");
        binarySortTree.inOrder();
    }

    @Test
    public void testDelete(){
        int[] nums = new int[]{7, 3, 10, 12, 5, 1, 9, 2};
        binarySortTree.create(nums);
        System.out.println("中序遍历二叉排序树：");
        binarySortTree.inOrder();
        //删除结点
        binarySortTree.delete(2);
        binarySortTree.delete(5);
        binarySortTree.delete(9);
        binarySortTree.delete(12);
        binarySortTree.delete(7);
        binarySortTree.delete(3);
        binarySortTree.delete(10);
        binarySortTree.delete(1);
        System.out.println();
        System.out.println("删除节点后：");
        binarySortTree.inOrder();
    }
}