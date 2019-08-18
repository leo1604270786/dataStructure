package com.zys.huffmantree;

import java.util.*;

/**
 * @program: dataStructure
 * @description: 哈夫曼编码
 * @author: Leo
 * @create: 2019-08-18 20:29
 **/
public class HuffmanCode {
    //哈夫曼编码表
    private static Map<Character, String> huffmanCode = new HashMap<>();

    /**
     * 返回字符串根据哈夫曼编码压缩后的字节数组
     * @param content
     * @return
     */
    public static byte[] compress(String content){
        List<Node> nodes = getNodes(content);
        //创建哈夫曼树
        Node huffmanTree = createHuffmanTree(nodes);
        //进行哈夫曼编码
        encode(huffmanTree);
        //根据哈夫曼编码表对字符串进行压缩并返回
        return compress(content,huffmanCode);
    }

    /**
     * 根据其哈夫曼编码表对字符串进行压缩
     * @param content 带压缩的内容
     * @param huffmanCode content对应的哈夫曼编码表
     * @return 压缩后的字节数组
     */
    private static byte[] compress(String content, Map<Character, String> huffmanCode) {
        //根据哈夫曼编码，获得content编码表示（二进制）
        StringBuilder codeStr = new StringBuilder();
        char[] chars = content.toCharArray();
        for (char aChar : chars) {
            codeStr.append(huffmanCode.get(aChar));
        }
        //获取字节数（每8位一个字节），可能不是8的倍数，所以可以先+7
        int len = (codeStr.length() + 7) / 8;
        //压缩后的字节数组
        byte[] huffmanCodeBytes = new byte[len];
        for (int i = 0, index = 0; i < codeStr.length(); i += 8, index++) {
            //最后一次截取长度不够
            if (i + 8 > codeStr.length()) {
                huffmanCodeBytes[index] = (byte) Integer.parseInt(codeStr.substring(i), 2);
            } else {
                huffmanCodeBytes[index] = (byte) Integer.parseInt(codeStr.substring(i, i + 8), 2);
            }
        }
        return huffmanCodeBytes;
    }

    /**
     * 将root为根的哈夫曼树生成对应的哈夫曼编码
     *
     * @param root
     * @return
     */
    private static Map<Character, String> encode(Node root) {
        if (root == null)
            return null;
        StringBuilder path = new StringBuilder();
        getCodes(root.left, "0", path);
        getCodes(root.right, "1", path);
        return huffmanCode;
    }

    /**
     * 获取当前结点下的所有叶子结点的路径编码（即哈夫曼编码）
     *
     * @param node          当前结点
     * @param code          向左为“0” , 向右为“1”
     * @param stringBuilder 临时的用于拼接路径
     * @return
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder path = new StringBuilder(stringBuilder);
        path.append(code);
        if (node != null) {
            //非叶子结点
            if (node.ch == null) {
                //向左递归
                getCodes(node.left, "0", path);
                //向右递归
                getCodes(node.right, "1", path);
            }
            //叶子结点
            else {
                //放入Map中
                huffmanCode.put(node.ch, path.toString());
            }
        }
    }

    /**
     * 创建哈夫曼树
     *
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取出最小的两个二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //创建父节点
            Node parent = new Node(leftNode.value + rightNode.value, null);
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


    /**
     * 得到一个字符串中每个字符出现的次数
     *
     * @param content
     * @return
     */
    private static List<Node> getNodes(String content) {
        char[] chars = content.toCharArray();
        List<Node> nodes = new ArrayList<>();
        //遍历chars的到每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        //封装成List
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getValue(), entry.getKey()));
        }
        return nodes;
    }
}