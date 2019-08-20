package com.zys.test;

import org.junit.Test;

/**
 * @program: dataStructure
 * @description: 背包问题
 * @author: Leo
 * @create: 2019-08-19 23:42
 **/
public class KnapsackTest {

    /**
     * 01背包问题：每个物品只能放入一个
     */
    @Test
    public void testKnapsack() {
        //所有物品的重量
        int[] weights = new int[]{1, 4, 3};
        //所有物品的价值
        int[] values = new int[]{1500, 3000, 2000};
        //背包的容量
        int capacity = 4;
        //二维数组，val[i][j]表示前i个物品放入容量为j的背包中的最大价值
        int[][] val = new int[values.length + 1][capacity + 1];
        //记录最终结果
        int[][] strategy = new int[values.length + 1][capacity + 1];
        //动态规划处理，不处理第0行和第0列（因为其表示背包容量为0或前0件物品放入背包的情况）
        for (int i = 1; i < val.length; i++){ //将前i件物品放入背包
            for (int j = 1; j < val[0].length; j++){ //背包容量递增，直到最大容量
                //如果第i件物品的重量大于当前背包容量(j)，不考虑放入该物品，
                // 直接使用前i-1件物品放入容量为j的背包中的最大价值
                if (weights[i-1] > j){ //weights[i-1]即为第i件物品的重量（从0开始）
                    val[i][j] = val[i-1][j];
                }
                //如果第i件物品的重量小于等于当前背包容量(j)，可以考虑放入该物品
                else {
                    //选取（前i-1件物品放入容量为j的背包中的最大价值） 与
                    // （放入当前物品价值(values[i-1]) + 前i-1件物品放入容量为剩余重量(j-weights[i-1])的背包中的最大价值） 中较大的值
                    val[i][j] = Math.max(val[i-1][j], values[i-1] + val[i-1][j - weights[i-1]]);
                    if (val[i-1][j] < values[i-1] + val[i-1][j - weights[i-1]]){
                        strategy[i][j] = 1;
                    }
                }
            }
        }

        //输出val
        for (int i = 0; i < val.length; i++){
            for (int j = 0; j < val[0].length; j++){
                System.out.print(val[i][j] + " ");
            }
            System.out.println();
        }
        //物品放入背包情况
        int i = val.length-1;
        int j = val[0].length-1;
        while (i > 0 && j > 0){
            if (strategy[i][j] == 1){
                System.out.println("将第" + i + "件物品放入背包" );
                j -= weights[i-1];
            }
            i--;
        }

    }
}