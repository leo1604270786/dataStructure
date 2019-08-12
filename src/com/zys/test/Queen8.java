package com.zys.test;

import org.junit.Test;

/**
 * @program: dataStructure
 * @description: 八皇后问题
 * @author: Leo
 * @create: 2019-07-28 21:22
 **/
public class Queen8 {
    int max = 8;
    int[] arr = new int[max];
    //解法个数
    int count = 0;
    //冲突判断次数
    int checkConflictCount = 0;

    @Test
    public void testPlaceQueen(){
        placeQueen(0);
        System.out.println("共有 " + count + " 种解法。");
        System.out.println("共执行 " + checkConflictCount + " 次冲突判断。");
    }

    /**
     * 打印一种结果
     */
    public void print() {
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 检查当前皇后是否和之前已经放置的皇后冲突
     * @param n 第n个皇后
     * @return
     */
    public boolean checkConflict(int n) {
        checkConflictCount++;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || n - i == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 放置
     * @param n
     */
    public void placeQueen(int n){
        if (n == max){
            print();
            count++;
            return;
        }
        //依次放入前n个皇后，并检查冲突
        for (int i = 0; i < max; i++){
            arr[n] = i;
            //不冲突
            if (checkConflict(n)){
                //放置第n+1个皇后
                placeQueen(n+1);
            }
        }
    }
}