package com.mobin.JianZhiOffer;

/**
 * Created by Mobin on 2016/5/6.
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class SearchFromTwoDimensionalArray {

    public static  boolean find(int [][] array,int target) {
        boolean found = false;
        int rows = array.length;     //总行数
        int columns = array[0].length;   //总列数
        if(array != null && rows > 0 && columns >= 0){
            int row = 0;
            int column = columns - 1;//从右上角开始查的
            while(row < rows && column >= 0){
                if(array[row][column] == target){
                    found = true;
                    break;
                }else if(array[row][column] > target) //说明要查找的元素不在当前元素的这一列，可以剔除掉这列
                    column --;
                else
                    ++ row;
            }
        }
        return found;
    }


    public static void main(String[] args) {
          int[][] array = new int[4][4];
          array[0] = new int[]{1,2,8,9};
          array[1] = new int[]{2,4,9,12};
          array[2] = new int[]{4,7,10,13};
          array[3] = new int[]{6,8,11,15};
        System.out.println(find(array,7));

    }
}
