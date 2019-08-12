package com.zys.binarytree;

/**
 * @program: dataStructure
 * @description: 二叉树接口 可以采用顺序存储、也可采用链式存储
 * @author: Leo
 * @create: 2019-05-16 11:49
 **/
public interface BinaryTree {
    /**
    * @Description: 是否是一棵空树
    * @return: boolean
    * @Author: Leo
    */
    boolean isEmpty();
    /**
    * @Description: 返回树的结点总数
    * @return: int
    * @Author: Leo
    */
    int size();
    /**
    * @Description: 返回树的高度
    * @return: int
    * @Author: Leo
    */
    int getHeight();
    /**
    * @Description: 根据值查找对应结点
    * @Param: [value]
    * @return: com.zys.binarytree.TreeNode
    * @Author: Leo
    */
    TreeNode findKey(Object value);
    /**
    * @Description: 先序遍历 递归
    * @return: void
    * @Author: Leo
    */
    void preOrderTraverse();
    /**
    * @Description: 中序遍历 递归
    * @return: void
    * @Author: Leo
    */
    void inOrderTraverse();
    /**
    * @Description: 后序遍历 递归
    * @return: void
    * @Author: Leo
    */
    void postOrderTraverse();
    /**
    * @Description: 前序遍历 非递归
    * @return: void
    * @Author: Leo
    */
    void preOrderByStack();
    /**
    * @Description: 中序遍历 非递归
    * @return: void
    * @Author: Leo
    */
    void inOrderByStack();
    /**
    * @Description: 后序遍历 非递归
    * @return: void
    * @Author: Leo
    */
    void postOrderByStack();
    /**
     * @Description: 后序遍历 非递归 方法二
     * @return: void
     * @Author: Leo
     */
    void postOrderByStack2();
    /**
    * @Description: 层次遍历 （无法使用递归完成） 借助队列实现
    * @return: void
    * @Author: Leo
    */
    void levelOrderByQueue();
}