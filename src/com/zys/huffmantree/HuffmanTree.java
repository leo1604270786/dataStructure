package com.zys.huffmantree;

import java.util.*;

/**
 * @program: dataStructure
 * @description: 哈夫曼树
 * @author: Leo
 * @create: 2019-08-18 16:56
 **/
public class HuffmanTree {

    /**
     * 创建一颗哈夫曼树
     * @param arr 权值数组
     * @return
     */
    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<>();
        //将数组中的数封装成Node节点
        for (int i : arr) {
            nodes.add(new Node(i));
        }
        while (nodes.size() > 1){
            //排序
            Collections.sort(nodes);
            //取出最小的两个二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //创建父节点
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //删除处理过的左右子树，并将新树节点放入list等待处理
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        //最后留在list中的即为哈夫曼树根节点
        return nodes.get(0);
    }

    public static void levelOrder(Node root){
        if(root == null)
            return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            if (curr.left != null)
                queue.offer(curr.left);
            if(curr.right != null)
                queue.offer(curr.right);
            System.out.print(curr.value + " ");
        }
    }
}