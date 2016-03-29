package com.mobin.sort;

/**
 * Created by Mobin on 2016/3/29.
 * 思路：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环
 * 内循环：比较当前元素与已知元素
 * 外循环：交换元素
 */
public class SelectSort {


    private static void selectSort(int[] arr) {
             for(int i= 0; i < arr.length; i ++){
                 int temp = arr[i];
                 int flag = i;     //记录最小元素的下标，方便后面进行元素交换
                 for(int j = i+1; j < arr.length && temp > arr[j]; j ++){
                         temp = arr[j];
                         flag = j;
                 }
                 arr[flag] = arr[i];
                 arr[i] = temp;
             }
    }

    public static void main(String[] args) {
        int arr[] = {0,2,1,5,5};

        System.out.println("排序之前：");
        for(int element : arr){
            System.out.print(element+" ");
        }

        selectSort(arr);
        System.out.println("\n排序之后：");
        for(int element : arr){
            System.out.print(element+" ");
        }
    }


}
