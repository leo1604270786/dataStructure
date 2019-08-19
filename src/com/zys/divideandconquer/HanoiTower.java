package com.zys.divideandconquer;

/**
 * @program: dataStructure
 * @description: 汉诺塔问题
 * @author: Leo
 * @create: 2019-08-19 22:14
 **/
public class HanoiTower {
    /**
     * 输出汉诺塔移动步骤
     *
     * @param num 汉诺塔盘子个数
     * @param a
     * @param b
     * @param c
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第 " + num + " 个盘从 " + a + " -> " + c);
        } else {
            //如果num >= 2，总是看做是 最底下一个盘和上面的所有盘当成一个盘
            //1. 将上面所有的盘 从柱子 a 移动到 b，可能借助 c
            hanoiTower(num - 1, a, c, b);
            //2. 将最下面的盘从 a 移动到 c
            System.out.println("第 " + num + " 个盘从 " + a + " -> " + c);
            //3. 将b柱子上所有盘移动到c， 移动过程可能借助a
            hanoiTower(num - 1, b, a, c);
        }
    }
}