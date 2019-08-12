package com.zys.sparsearray;

import org.junit.Test;

import java.io.*;

/**
 * @program: dataStructure
 * @description: 稀疏数组
 * @author: Leo
 * @create: 2019-07-26 08:45
 **/
public class SparseArray {
    private int[][] chessArray;
    @Test
    public void test1(){
        //初始化原始二维数组
        initOriginArray();
        //输出二维数组
        System.out.println("原始二维数组：");
        printOriginArray(chessArray);

        //将二维数组转 稀疏数组
        int[][] sparseArray = originArray2sparseArray();
        System.out.println("稀疏数组：");
        //输出稀疏数组
        printSparseArray(sparseArray);
        //将稀疏数组写入文件
        writeSparseArray2file(sparseArray);
        //从文件中读取稀疏数组
        sparseArray = readSparseArrayFromFile(sparseArray.length,3);
        System.out.println("从文件中读取的稀疏数组：");
        //输出稀疏数组
        printSparseArray(sparseArray);
        //将稀疏数组转原始二维数组
        chessArray = sparseArray2originArray(sparseArray);
        //输出转化来的原始二维数组
        System.out.println("稀疏数组 =》 原始二维数组：");
        printOriginArray(chessArray);
    }
    /**
     * 初始化原始二维数组
     */
    private void initOriginArray(){
        //创建原始二维数组 11*11
        //0表示无棋子 ，1表示黑子  2表示蓝子
        chessArray = new int[11][11];
        //初始化二维数组
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
    }
    /**
     * 输出原始二维数组
     * @param chessArray
     */
    private void printOriginArray(int[][] chessArray){
        for (int[] row : chessArray) {
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
    /**
     * 输出稀疏数组
     * @param sparseArray
     */
    private void printSparseArray(int[][] sparseArray){
        for(int[] row : sparseArray){
            System.out.printf("%d\t%d\t%d\n",row[0],row[1],row[2]);
        }
    }
    /**
     * 将二维数组转换为稀疏数组
     * @return
     */
    private int[][] originArray2sparseArray(){
        //将二维数组转 稀疏数组
        //1.得到非0元素个数
        int sum = 0;
        for(int[] row : chessArray){
            for(int data : row){
                if(data != 0)
                    sum++;
            }
        }
        //输出非零元素总个数
        //System.out.println("非0元素个数：" + sum);
        //2.创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组第一行（原数组 行、列、非零元素个数）赋值
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[0].length;
        sparseArray[0][2] = sum;
        int index = 1;
        //3.遍历二维数组，将非零元素记录至稀疏数组
        for (int i = 0; i < chessArray.length; i++){
            for (int j = 0; j < chessArray[0].length; j++){
                if(chessArray[i][j] != 0){
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index++][2] = chessArray[i][j];
                }
            }
        }
        return sparseArray;
    }
    /**
     * 将稀疏数组恢复至原始二维数组
     * @param sparseArray
     * @return
     */
    private int[][] sparseArray2originArray(int[][] sparseArray){
        //将稀疏数组转原始二维数组
        //1.先读取稀疏数组的第一行，根据第一行数据创建原始二维数组
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int valCount = sparseArray[0][2];
        int[][] chessArray = new int[row][col];
        //2.读取稀疏数组非零元素的信息，赋给原始二维数组（再填充默认值）
        for(int i = 1; i < sparseArray.length; i++){
            chessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return chessArray;
    }

    /**
     * 将稀疏数组写入文件
     * @param sparseArray
     */
    private void writeSparseArray2file(int[][] sparseArray){
        try {
            File file = new File("D:/Workspace/array.txt");
            FileWriter fileWriter = new FileWriter(file);
            for (int[] row : sparseArray) {
                for (int data : row) {
                    fileWriter.write(data + ",");
                }
                fileWriter.write("\r\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中读取稀疏数组
     * @param row
     * @param col
     * @return
     */
    private int[][] readSparseArrayFromFile(int row, int col){
        int[][] sparseArray = new int[row][col];
        try {
            File file = new File("D:/Workspace/array.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int index = 0;
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] temp = line.split(",");
                for (int i = 0; i < temp.length; i++){
                    sparseArray[index][i] = Integer.parseInt(temp[i]);
                }
                index++;
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sparseArray;
    }
}