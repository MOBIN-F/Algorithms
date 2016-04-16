package com.mobin.sort;

/**
 * Created by Mobin on 2016/4/16.
 */
public class BubbleSort {
    public static void bubbleSort(int arr[]){
        int temp;
        for(int i= 0; i < arr.length-1; i ++){//有N个元素只需比较N-1次
             for(int  j = arr.length-1; j > i; j --){//比较找到本真趟最小的元素
            if(arr[j] < arr[j-1]){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }
}
    public static void main(String[] args) {
        int array[] = {5,8,4,1,2,9};
        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element + " ");
        }

        bubbleSort(array);
        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element + " ");
        }
    }

}