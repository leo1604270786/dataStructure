package com.zys.binarytree;

/**
 * @program: dataStructure
 * @description: 二叉排序（搜索）树
 * @author: Leo
 * @create: 2019-08-19 14:29
 **/
public class BinarySortTree {
    //根结点
    protected TreeNode root;

    /**
     * 删除值为value的结点
     * @param value
     */
    public void delete(int value){
        if (root == null){
            System.out.println("二叉排序树为空，不能删除结点。");
            return;
        }
        //1.找到要删除的结点
        TreeNode targetNode = search(value);
        if (targetNode == null)
            return;
        //如果待删除结点为根结点且当前二叉树只有一个节点
        if (value == root.value && root.leftChild == null && root.rightChild == null){
            root = null;
            return;
        }
        //2.找到待删除结点的父节点
        TreeNode parent = searchParent(value);
        //3.1如果待删除结点为叶子结点
        if (targetNode.leftChild == null && targetNode.rightChild == null){
            //判断待删除结点位于父节点的左边还是右边
            //左子节点
            if (parent.leftChild != null && parent.leftChild.value == value){
                parent.leftChild = null;
            } else if (parent.rightChild != null && parent.rightChild.value == value){
                parent.rightChild = null;
            }
        }
        //3.2如果待删除结点的度为2（即左右子节点都不为空）
        else if(targetNode.leftChild != null && targetNode.rightChild != null){
            TreeNode temp = targetNode.rightChild;
            //从右子树中找到最小值（也可从左子树中找到最大值），并删除该节点
            while (temp.leftChild != null){
                temp = temp.leftChild;
            }
            //temp此时指向值最小的节点
            int minValue = temp.value;
            //删除该节点
            delete(minValue);
            //将最小值赋给待删除结点
            targetNode.value = minValue;
        }
        //3.3如果待删除结点的度为1（即左子节点不为空或右子节点不为空）
        else {
            //如果待删除结点有左子节点
            if (targetNode.leftChild != null){
                //父节点不为空
                if (parent != null){
                    //如果待删除结点为父节点的左子节点
                    if (parent.leftChild.value == value){
                        parent.leftChild = targetNode.leftChild;
                    } else {
                        parent.rightChild = targetNode.leftChild;
                    }
                } else { //说明待删除结点为当前排序树的根结点
                    root = targetNode.leftChild;
                }

            } else {
                //父节点不为空
                if (parent != null){
                    //如果待删除结点为父节点的左子节点
                    if (parent.leftChild.value == value){
                        parent.leftChild = targetNode.rightChild;
                    } else {
                        parent.rightChild = targetNode.rightChild;
                    }
                } else {  //说明待删除结点为当前排序树的根结点
                    root = targetNode.rightChild;
                }
            }
        }
    }

    /**
     * 根据值在二叉排序树中查找结点
     *
     * @param value
     * @return
     */
    public TreeNode search(int value) {
        if (root == null) {
            System.out.println("二叉排序树为空，不能查找。");
            return null;
        }
        return search(root, value);
    }

    /**
     * 在以当前结点为根结点的树中查找值为value的结点
     *
     * @param curr
     * @param value
     * @return
     */
    protected TreeNode search(TreeNode curr, int value) {
        if (curr == null)
            return null;
        if (value == curr.value) {
            return curr;
        }
        //小于当前结点的值
        else if (value < curr.value) {
            //向左子树查找
            return search(curr.leftChild, value);
        } else {
            return search(curr.rightChild, value);
        }
    }

    /**
     * 根据值查找其在二叉排序树中结点的父节点
     *
     * @param value
     * @return
     */
    public TreeNode searchParent(int value) {
        if (root == null) {
            System.out.println("二叉排序树为空，不能查找。");
            return null;
        }
        return searchParent(root, value);
    }

    /**
     * 在以当前结点为根结点的树中查找值为value的结点的父节点
     *
     * @param curr
     * @param value
     * @return
     */
    protected TreeNode searchParent(TreeNode curr, int value) {
        if (curr == null)
            return null;
        if ((curr.leftChild != null && curr.leftChild.value == value)
                || (curr.rightChild != null && curr.rightChild.value == value)) {
            return curr;
        } else {
            if (value < curr.value && curr.leftChild != null) {
                return searchParent(curr.leftChild, value);
            } else if (value > curr.value && curr.rightChild != null) {
                return searchParent(curr.rightChild, value);
            } else { //无父节点
                return null;
            }
        }
    }

    /**
     * 根据给定的序列创建二叉排序树
     *
     * @param arr
     */
    public void create(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(new TreeNode(arr[i]));
        }
    }

    /**
     * 将节点加入到二叉排序树中
     *
     * @param node
     */
    public void add(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }
    }

    /**
     * 将node节点加到以curr为根节点的子树中
     *
     * @param curr
     * @param node
     */
    protected void add(TreeNode curr, TreeNode node) {
        if (curr != null) {
            //大于当前根结点，向右子树继续比较
            if (node.value > curr.value) {
                if (curr.rightChild == null) {
                    curr.rightChild = node;
                } else {
                    add(curr.rightChild, node);
                }
            } else {
                if (curr.leftChild == null) {
                    curr.leftChild = node;
                } else {
                    add(curr.leftChild, node);
                }
            }
        }
    }

    /**
     * 对二叉排序树进行中序遍历
     */
    public void inOrder() {
        if (root == null) {
            System.out.println("二叉排序树为空，不能遍历。");
        }
        inOrder(root);
    }

    /**
     * 对二叉排序树进行中序遍历
     *
     * @param node
     */
    protected void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.print(node.value + " ");
            inOrder(node.rightChild);
        }
    }
}