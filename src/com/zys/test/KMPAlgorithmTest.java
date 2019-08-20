package com.zys.test;

import org.junit.Test;

/**
 * @program: dataStructure
 * @description: KMP算法实现
 * @author: Leo
 * @create: 2019-08-20 10:11
 **/
public class KMPAlgorithmTest {

    /**
     * 使用KMP算法查找模式串在主串中第一次出现的索引
     *
     * @param str1 主串
     * @param str2 模式串
     * @return 不存在则返回-1
     */
    public static int kmpSearch(String str1, String str2) {
        //模式串对应的部分匹配表
        int[] next = getNext(str2);
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 获取str字符串的部分匹配表
     * 部分匹配表的每一项表示：字符串的最长的公共前缀后缀的长度
     *
     * @param str
     * @return
     */
    private static int[] getNext(String str) {
        int[] next = new int[str.length()];
        //长度为1的字符串的最长的公共前缀后缀的长度为0
        next[0] = 0;
        for (int i = 1, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    @Test
    public void testKmpSearch() {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int index = kmpSearch(str1, str2);
        System.out.println("字符串：[" + str2 + "] 在字符串：[" + str1 + "] 中第一次出现的索引为：" + index);
    }
}