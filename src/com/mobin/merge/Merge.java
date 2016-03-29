package com.mobin.merge;

/**
 * Created by Mobin on 2016/2/28.
 */
public class Merge {
    private static Comparable[] aux;

    public static  void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length - 1);
        for (int n = 0; n < a.length -1; n ++) {
            System.out.print(a[n]+ " ");
        }
    }
    private static  void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo)
            return;
        int mid = (lo + hi)/2;
        sort(a, lo, mid);
        sort(a,mid+1, hi);
        merge(a, lo, mid, hi);
    }

    private static  void merge(Comparable[] a,int lo, int mid, int hi){
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k ++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k ++){
            if(i > mid)
                a[k] = aux[j ++];
            else if(j > hi)
                a[k] = aux[i ++];
            else if(less(aux[j] , aux[i]))
                a[k] = aux[j ++];
            else
                a[k] = aux[i ++];
        }
    }

    private static  boolean less(Comparable v,Comparable w){
        return  v.compareTo(w) < 0;
    }

    public static  void  main(String[] args){
       // Comparable[] arr = {'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'};
        Comparable[] arr1 = {5,1,4,5,6,2,5,1,0,3};
        sort(arr1);

    }
}
