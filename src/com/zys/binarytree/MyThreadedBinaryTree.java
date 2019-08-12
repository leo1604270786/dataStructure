package com.zys.binarytree;

/**
 * @program: dataStructure
 * @description: 线索二叉树(中序)
 * @author: Leo
 * @create: 2019-08-08 20:55
 **/
public class MyThreadedBinaryTree implements BinaryTree {
    //根结点
    private ThreadedTreeNode root;
    //线索化辅助指针，指向当前处理结点的前一个结点
    private ThreadedTreeNode pre;

    public MyThreadedBinaryTree(ThreadedTreeNode root) {
        this.root = root;
    }

    /**
     * 线索化二叉树（中序）
     */
    public void threadedNode(){
        threadedNode(root);
    }

    /**
     * 线索化结点
     * @param node
     */
    private void threadedNode(ThreadedTreeNode node){
        if (node != null){
            //1.线索化左子树
            threadedNode(node.getLeftChild());
            //2.线索化当前结点
            //如果左指针为空，则线索化前驱结点
            if (node.getLeftChild() == null){
                //将左指针指向前驱结点
                node.setLeftChild(pre);
                //改变左指针标志
                node.setLeftTag(1);
            }
            //如果前驱结点不为空，且前驱结点右指针为空
            //就是将当前结点的右指针的线索化放在下次处理
            if (pre != null && pre.getRightChild() == null){
                //将前驱结点的右指针指向当前结点
                pre.setRightChild(node);
                //改变前驱结点右指针的标志
                pre.setRightTag(1);
            }
            //将前驱结点指向当前结点
            //每次处理了一个结点，当前结点就是下次处理结点的前驱结点
            pre = node;
            //3.线索化右子树
            threadedNode(node.getRightChild());
        }
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

    @Override
    public void preOrderTraverse() {

    }

    /**
     * 遍历线索二叉树（中序）
     */
    @Override
    public void inOrderTraverse() {
        ThreadedTreeNode node = root;
        while (node != null){
            //找到第一个leftTag为1的结点
            while (node.getLeftTag() != 1){
                node = node.getLeftChild();
            }
            //打印当前结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点，就一直输出且后移
            while (node.getRightTag() == 1){
                node = node.getRightChild();
                System.out.println(node);
            }
            //
            node = node.getRightChild();
        }
    }

    @Override
    public void postOrderTraverse() {

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
