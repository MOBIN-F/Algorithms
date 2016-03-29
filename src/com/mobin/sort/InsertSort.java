package com.mobin.sort;

/**
 * Created by Mobin on 2016/2/22.
 * 排序思路：每次将一个待排序的元素与已排序的元素进行逐一比较，直到找到合适的位置按大小插入。
 * 发现比pre元素小时，就把pre元素之后的元素（包含）往后移，pre元素腾出的位置插入当前元素
 */
public class InsertSort {
    public static  void insertSort(int[] arr){
        int len = arr.length;
        for(int i = 1; i < len; i ++) {
            if (arr[i] < arr[i-1]) {///注意[0,i-1]都是有序的。如果待插入元素比arr[i-1]还大则无需再与[i-1]前面的元素进行比较了，反之则进入if语句
                for (int j = i; j > 0  && arr[j] < arr[j - 1]; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];   //把比arr[j]大的元素后移
                    arr[j - 1] = temp;  //把待插入的元素插入腾出的位置
                }
            }
        }

    }
    public static void main(String[] args) {
        int array[] = {0,2,1,5,5};

        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }

        insertSort(array);
        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }
    }
}
