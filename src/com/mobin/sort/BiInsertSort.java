package com.mobin.sort;

/**
 * Created by Mobin on 2016/3/30.
 */
public class BiInsertSort {
    public static void biInsertSort(int arr[]){
        for(int i = 1; i < arr.length; i ++){
            int temp = arr[i];
            int left = 0;
            int right = i-1;
            while(left <= right){//通过拆装查找找到插入位置
                int mid = (left+right)/2;
                if(temp < arr[mid]){//插入点在[left,mid-1]
                    right = mid-1;
                }else               //插入点在[mid+1,right]
                    left = mid+1;
            }//直到找到合适的位置（left或right+1），接下来就将left/right+1（包括）后的元素后移
            for(int j = i-1;j >= right+1; j --){
                arr[j+1] = arr[j];
            }
            arr[right+1] = temp;     //正确的插入位置
        }
    }
    public static void main(String[] args) {
        int array[] = {2,5,3,1,5,2,8};
        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }
        biInsertSort(array);
        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }
    }
}
