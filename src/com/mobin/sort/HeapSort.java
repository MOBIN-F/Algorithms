package com.mobin.sort;

/**
 * Created by Mobin on 2016/4/6.
 * 步骤：先构造堆
 * 再将最顶元素与最后一个元素交换，再调整堆
 */
public class HeapSort {


    private static void heapSort(int[] arr) {
        int len = arr.length -1;
        for(int i = len/2 - 1; i >=0; i --){ //堆构造
             sink(arr,i,len);
        }

        while (len >=0){
            swap(arr,0,len--);
            sink(arr,0,len);

        }

    }

public static  void sink(int[] arr,int i,int len){
    while(2*i < len){
        int j = 2*i + 1;
        int left = j;
        int right = j + 1;
        if(j < len && arr[left] < arr[right])
            j ++;

        if(arr[i] < arr[j])
            swap(arr,i,j);

        else
            break;
        i = j;

    }
}

    public static  void swap(int[] arr,int i,int len){
             int temp = arr[i];
              arr[i] = arr[len];
             arr[len] = temp;
    }


    public static void main(String[] args) {
        int array[] = {1,5,3,1,7,2,8};
        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }

        heapSort(array);

        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }
    }


}
