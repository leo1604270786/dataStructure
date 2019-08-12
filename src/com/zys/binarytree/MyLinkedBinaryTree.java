package com.zys.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: dataStructure
 * @description: 采用链式存储结构的二叉树
 * @author: Leo
 * @create: 2019-05-16 12:16
 **/
public class MyLinkedBinaryTree implements BinaryTree{
    //树的根结点
    private TreeNode root;

    public MyLinkedBinaryTree() {

    }

    public MyLinkedBinaryTree(TreeNode root) {
        this.root = root;
    }

    /**
     * @Description: 是否是一棵空树
     * @return: boolean
     * @Author: Leo
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * @Description: 返回树的结点总数
     * @return: int
     * @Author: Leo
     */
    @Override
    public int size() {
        return size(root);
    }
    private int size(TreeNode root){
        //树为空 则 左、右孩子结点数为0 根结点数也为0
        if (root == null){
            return 0;
        }
        //树不为空则继续递归计算
        else {
            //计算左孩子结点数
            int leftSize = size(root.getLeftChild());
            //计算右孩子结点数
            int rightSize = size(root.getRightChild());
            //树的结点数 = 左孩子结点数 + 右孩子结点数 + 1
            return leftSize+rightSize+1;
        }
    }

    /**
     * @Description: 返回树的高度
     * @return: int
     * @Author: Leo
     */
    @Override
    public int getHeight() {
        return getHeight(root);
    }
    private int getHeight(TreeNode root){
        //树为空 则 左、右子树高度均为0 根高度也为0
        if (root == null){
            return 0;
        }
        //树不为空 继续计算树的高度
        else {
            //计算左子树高度
            int leftHeight = getHeight(root.getLeftChild());
            //计算右子树高度
            int rightHeight = getHeight(root.getRightChild());
            //树的高度 = max(左子树高度 , 右子树高度) + 1(根的高度)
            return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
        }
    }
    /**
     * @Description: 根据值查找对应结点
     * @Param: [value]
     * @return: com.zys.binarytree.TreeNode
     * @Author: Leo
     */
    @Override
    public TreeNode findKey(Object value) {
        return findKey(value,root);
    }
    private TreeNode findKey(Object value,TreeNode root) {
        //树为空
        if (root == null)
            return null;
        //找到了第一个与value值相等的结点
        else if (root.getValue() == value)
            return root;
        else {
            //在左子树中查找
            TreeNode leftResult = findKey(value,root.getLeftChild());
            //在右子树中查找
            TreeNode rightResult = findKey(value,root.getRightChild());
            //左子树中找到了
            if (leftResult != null)
                return leftResult;
            //右子树中找到或未找到
            return rightResult;
        }
    }
    /**
     * @Description: 先序遍历 递归
     * @return: void
     * @Author: Leo
     */
    @Override
    public void preOrderTraverse() {
        System.out.println("先序遍历（递归）：");
        preOrderTraverse(root);
        System.out.println();
    }
    private void preOrderTraverse(TreeNode root) {
        //树不为空
        if (root != null){
            //先输出根结点的值
            System.out.print(root.getValue()+" ");
            //遍历左子树
            preOrderTraverse(root.getLeftChild());
            //遍历右子树
            preOrderTraverse(root.getRightChild());
        }
    }
    /**
     * @Description: 中序遍历 递归
     * @return: void
     * @Author: Leo
     */
    @Override
    public void inOrderTraverse() {
        System.out.println("中序遍历（递归）：");
        inOrderTraverse(root);
        System.out.println();
    }
    private void inOrderTraverse(TreeNode root) {
        //树不为空
        if (root != null){
            //遍历左子树
            inOrderTraverse(root.getLeftChild());
            //输出根结点的值
            System.out.print(root.getValue() + " ");
            //遍历右子树
            inOrderTraverse(root.getRightChild());
        }
    }
    /**
     * @Description: 后序遍历 递归
     * @return: void
     * @Author: Leo
     */
    @Override
    public void postOrderTraverse() {
        System.out.println("后序遍历（递归）：");
        postOrderTraverse(root);
        System.out.println();
    }
    private void postOrderTraverse(TreeNode root) {
        //树不为空
        if (root != null){
            //遍历左子树
            postOrderTraverse(root.getLeftChild());
            //遍历右子树
            postOrderTraverse(root.getRightChild());
            //输出根结点的值
            System.out.print(root.getValue()+" ");
        }
    }
    /**
     * @Description: 前序遍历 非递归
     * @return: void
     * @Author: Leo
     */
    @Override
    public void preOrderByStack() {
        System.out.println("先序遍历（非递归）：");
        //树为空
        if (root == null)
            return;
        //创建栈
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        //栈不为空 并且 当前树不为空
        while (current != null || !stack.isEmpty()){
            while (current != null){
                //先输出根（相对目前操作的树而言）的值
                System.out.print(current.getValue()+" ");
                //将根入栈 方便回退
                stack.push(current);
                //将current往左孩子移动
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()){
                //回退至之前访问过的根
                current = stack.pop();
                current = current.getRightChild();
            }
        }
        System.out.println();
    }

    /**
     * @Description: 中序遍历 非递归
     * @return: void
     * @Author: Leo
     */
    @Override
    public void inOrderByStack() {
        System.out.println("中序遍历（非递归）：");
        //树为空
        if (root == null)
            return;
        //创建栈
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        //栈不为空 或者 当前树不为空
        while ( current != null || !stack.isEmpty()){
            while ( current != null){
                stack.push(current);
                //current一直往左孩子移动 直到为空
                current = current.getLeftChild();
            }
            //栈不为空
            if (!stack.isEmpty()){
                //栈顶元素出栈 赋给 current
                current = stack.pop();
                //输出current指向的结点的值
                System.out.print(current.getValue()+" ");
                //将current指向current的右孩子
                current = current.getRightChild();
            }
        }
        System.out.println();
    }

    /**
     * @Description: 后序遍历 非递归
     * @return: void
     * @Author: Leo
     */
    @Override
    public void postOrderByStack() {
        System.out.println("后序遍历（非递归）：");
        //树为空
        if (root == null)
            return;
        //创建栈
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        //将每个结点入栈两次
        stack.push(root);
        stack.push(root);
        //栈不为空
        while (!stack.isEmpty()){
            current = stack.pop();
            //当前节点 等于 栈顶元素 -> 表明此结点第一次出栈，未操作过其孩子结点 所以将其左右孩子入栈，先右后左
            if (!stack.isEmpty() && current == stack.peek()){
                if (current.getRightChild() != null){
                    stack.push(current.getRightChild());
                    stack.push(current.getRightChild());
                }
                if (current.getLeftChild() != null){
                    stack.push(current.getLeftChild());
                    stack.push(current.getLeftChild());
                }
            }
            //当前节点 不等于 栈顶元素  -> 表明已经操作过此结点的孩子结点 访问该结点
            else {
                System.out.print(current.getValue()+" ");
            }
        }
        System.out.println();
    }
    /**
    * @Description:  后序遍历 非递归 方法二
    * @return: void
    * @Author: Leo
    */
    public void postOrderByStack2(){
        System.out.println("后序遍历（非递归）方法二：");
        //树为空
        if (root == null)
            return;
        //创建栈
        Deque<TreeNode> stack = new LinkedList<>();
        //当前结点
        TreeNode current = root;
        //上一次访问的结点
        TreeNode last = null;
        stack.push(root);
        while (!stack.isEmpty()){
            current = stack.peek();
            // 第一种情况： 当前结点无左、右孩子 直接输出
            // 第二种情况： 当前结点无右孩子且左孩子刚访问过了 直接输出
            // 第三种情况： 当前结点的右孩子刚访问过了 直接输出
            if ( (current.getLeftChild() == null && current.getRightChild() == null)
                    || (current.getRightChild() == null && last != null && current.getLeftChild() == last)
                    || (last != null && current.getRightChild() == last)){
                System.out.print(current.getValue()+" ");
                //更改上一次访问的结点
                last = current;
                //当前结点出栈
                stack.pop();
            }
            //其他情况：将其左、右孩子结点入栈 先右后左
            else {
                if (current.getRightChild() != null)
                    stack.push(current.getRightChild());
                if (current.getLeftChild() != null)
                    stack.push(current.getLeftChild());
            }
        }
        System.out.println();
    }
    /**
     * @Description: 层次遍历 （无法使用递归完成） 借助队列实现
     * @return: void
     * @Author: Leo
     */
    @Override
    public void levelOrderByQueue() {
        System.out.println("层次遍历：");
        //树为空
        if (root == null)
            return;
        //创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        //根结点入队
        queue.offer(root);  //也可使用queue.add(root) 但更推荐使用offer 因为offer有返回值 可以判断是否入队成功
        //队列不为空
        while (queue.size() != 0){
            int len = queue.size();
            //依次处理队列中的元素
            for (int i = 0; i < len; i++){
                //队首元素出队
                TreeNode node = queue.poll();
                //输出队首元素的值
                System.out.print(node.getValue()+" ");
                //将队首元素的左孩子入队（不为空）
                if (node.getLeftChild() != null)
                    queue.add(node.getLeftChild());
                //将队首元素的右孩子入队（不为空）
                if (node.getRightChild() != null)
                    queue.add(node.getRightChild());
            }
        }
        System.out.println();
    }
}