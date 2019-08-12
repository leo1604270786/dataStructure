package com.zys.test;

import org.junit.Test;

/**
 * @program: dataStructure
 * @description: 递归测试类
 * @author: Leo
 * @create: 2019-07-28 20:11
 **/
public class RecursionTest {

    @Test
    public void testPrint() {
        print(5);
    }

    @Test
    public void testFactorial() {
        int result = factorial(4);
        System.out.println("result=" + result);
    }

    @Test
    public void testMaze(){
        int[][] map = new int[8][7];
        initMap(map);
        //设置障碍
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("地图初始状态：");
        printMap(map);

        hasWay(map,1,1);
        System.out.println("地图探测过后状态：");
        printMap(map);
    }
    /**
     * 打印问题
     *
     * @param n
     */
    public void print(int n) {
        if (n > 2) {
            print(n - 1);
        }
        System.out.println("n=" + n);
    }

    /**
     * 阶乘问题
     *
     * @param n
     * @return
     */
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    /**
     * 初始化地图
     * @param map
     */
    public void initMap(int[][] map){
        //将第一行和最后一行置为1（表示墙）
        for (int col = 0; col < map[0].length; col++){
            map[0][col] = 1;
            map[map.length-1][col] = 1;
        }
        //将第一列和最后一列置为1
        for (int row = 0; row < map.length; row++){
            map[row][0] = 1;
            map[row][map[0].length-1] = 1;
        }
    }
    /**
     * 打印地图
     * @param map
     */
    public void printMap(int[][] map){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 通过递归，回溯 找到一条路
     * 约定：1表示墙，2表示通路，3表示已经走过，但走不通
     *       策略：下->右->上->左   走不通回溯
     *       终点：map[6][5]
     * @param map 地图
     * @param i 出发点x坐标
     * @param j 出发点y坐标
     * @return 是否找到了通路
     */
    public boolean hasWay(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }else {
            //当前点还未走过，就根据策略开始走
            if (map[i][j] == 0){
                //假定改点可以走通
                map[i][j] = 2;
                //向下走
                if (hasWay(map,i+1,j)){
                    return true;
                }
                //向右走
                else if (hasWay(map,i,j+1)){
                    return true;
                }
                //向上走
                else if (hasWay(map,i-1,j)){
                    return true;
                }
                //向左走
                else if (hasWay(map,i,j-1)){
                    return true;
                }
                //走不通
                else {
                    map[i][j] = 3;
                    return false;
                }
            }
            //当前点已经走过  1,2,3
            else {
                return false;
            }
        }
    }
}