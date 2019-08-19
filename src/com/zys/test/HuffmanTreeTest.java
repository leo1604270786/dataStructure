package com.zys.test;

import com.zys.huffmantree.HuffmanCode;
import com.zys.huffmantree.HuffmanTree;
import com.zys.huffmantree.Node;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @program: dataStructure
 * @description:
 * @author: Leo
 * @create: 2019-08-18 17:04
 **/
public class HuffmanTreeTest {

    @Test
    public void testCreateHuffmanTree() {
        int[] arr = new int[]{13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = HuffmanTree.createHuffmanTree(arr);
        System.out.println("根节点：" + huffmanTree);
        System.out.println("层次遍历：");
        HuffmanTree.levelOrder(huffmanTree);
    }

    @Test
    public void testHuffmanCode() {
        //============================测试
        /*String content = "i like like like java do you like a java";
        List<Node> nodes = HuffmanCode.getNodes(content);
        System.out.println("nodes = " + nodes);
        Node huffmanTree = HuffmanCode.createHuffmanTree(nodes);
        System.out.println("层次遍历：");
        HuffmanTree.levelOrder(huffmanTree);
        System.out.println();
        System.out.println("哈夫曼编码：");
        Map<Character, String> huffmanCode = HuffmanCode.encode(huffmanTree);
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            System.out.println("data = " + entry.getKey() + " : code = " + entry.getValue());
        }*/
    }

    @Test
    public void testCompress() {
        //待压缩内容
        /*String content = "i like like like java do you like a java";
        List<Node> nodes = HuffmanCode.getNodes(content);
        Node huffmanTree = HuffmanCode.createHuffmanTree(nodes);
        Map<Character, String> huffmanCode = HuffmanCode.encode(huffmanTree);
        byte[] compress = HuffmanCode.compress(content, huffmanCode);
        System.out.println("压缩前的字节数组：" + Arrays.toString(content.getBytes()));
        System.out.println("压缩后的字节数组：" + Arrays.toString(compress));
        int lenBefore = content.getBytes().length;
        int lenAfter = compress.length;
        System.out.println("压缩前字节数组长度：" + lenBefore);
        System.out.println("压缩后字节数组长度：" + lenAfter);
        System.out.println("压缩率：" + (double) 100 * (lenBefore - lenAfter) / lenBefore + " %");*/
        //=======================================封装后
        //待压缩内容
        String content = "i like like like java do you like a java";
        byte[] compress = HuffmanCode.compress(content);
        System.out.println("压缩前的字节数组：" + Arrays.toString(content.getBytes()));
        System.out.println("压缩后的字节数组：" + Arrays.toString(compress));
        int lenBefore = content.getBytes().length;
        int lenAfter = compress.length;
        System.out.println("压缩前字节数组长度：" + lenBefore);
        System.out.println("压缩后字节数组长度：" + lenAfter);
        System.out.println("压缩率：" + (double) 100 * (lenBefore - lenAfter) / lenBefore + " %");
    }

    @Test
    public void testDecompress(){
        //待压缩内容
        String content = "i like like like java do you like a java";
        System.out.println("压缩前文本内容：" + content);
        //编码并压缩
        byte[] compress = HuffmanCode.compress(content);
        //解压并解码
        String source = HuffmanCode.decompress(compress);
        System.out.println("解压、解码后原始文本内容 : " + source);
    }
}