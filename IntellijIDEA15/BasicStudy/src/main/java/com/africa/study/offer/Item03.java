package com.africa.study.offer;

import java.time.Clock;

/**
 * 二维数组的查找问题
 * 行 数值递增
 * 列 数值递增
 * 查找某个值，右上角或者左下角
 *
 * @author zhuhusheng
 * @date 2016/12/22
 */
public class Item03 {
    public static void main(String[] args) {
        int[][] values = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10 ,13},
                {6, 8, 11, 15}
        };
        System.out.println(rightUpFind(values, 1));
        System.out.println(leftDownFind(values, 1));
    }


    public static boolean rightUpFind(int[][] array, int number){
        long start = Clock.systemDefaultZone().millis();
        boolean result = false;
        int rows = array.length;
        int columns = array[0].length;
        int row = 0;
        int column = columns - 1;
        while(row < rows && column >= 0) {
            if(array[row][column] == number) {
                result = true;
                break;
            } else if(array[row][column] > number) {
                // 列变小
                column--;
            } else {
                // 行增加
                row++;
            }
        }
        long stop = Clock.systemDefaultZone().millis();
        System.out.println("查找用时：" + (stop - start));
        return result;
    }

    public static boolean leftDownFind(int[][] array, int number){
        long start = Clock.systemDefaultZone().millis();
        boolean result = false;
        int rows = array.length;
        int columns = array[0].length;
        int row = rows - 1;
        int column = 0;
        while(column < columns && row >= 0) {
            if(array[row][column] == number) {
                result = true;
                break;
            } else if(array[row][column] > number) {
                // 列变小
                row--;
            } else {
                // 行增加
                column++;
            }
        }
        long stop = Clock.systemDefaultZone().millis();
        System.out.println("查找用时：" + (stop - start));
        return result;
    }
}
