package com.zys.binarytree;

/**
 * @program: dataStructure
 * @description: AVL树（是一种特殊的二叉排序树，所以继承二叉排序树）
 * @author: Leo
 * @create: 2019-08-19 16:46
 **/
public class AVLTree extends BinarySortTree {
    //根结点使用继承的根结点


    /**
     * 对传入结点进行左旋转
     * @param curr
     */
    public void leftRotate(TreeNode curr){
        //1. 创建新节点，值为传入结点
        TreeNode newNode = new TreeNode(curr.value);
        //2. 将新节点的左子树指向当前结点的左子树
        newNode.leftChild = curr.leftChild;
        //3. 将新节点的右子树指向当前结点的右子树的左子树
        newNode.rightChild = curr.rightChild.leftChild;
        //4. 用右子节点的值替换当前结点的值
        curr.value = curr.rightChild.value;
        //5. 将当前结点的右子树指向右子树的右子树
        curr.rightChild = curr.rightChild.rightChild;
        //6. 将当前结点的左子树设为新创建的结点
        curr.leftChild = newNode;
    }

    /**
     * 返回当前AVL树的高度
     *
     * @return
     */
    public int getHeight() {
        if (root == null) {
            return -1;
        }
        return getHeight(root);
    }

    /**
     * 获取以当前结点为根结点的树的高度
     *
     * @param node
     * @return
     */
    public int getHeight(TreeNode node) {
        return Math.max(node.leftChild == null ? 0 : getHeight(node.leftChild),
                node.rightChild == null ? 0 : getHeight(node.rightChild)) + 1;
    }
}