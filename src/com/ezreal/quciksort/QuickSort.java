package com.ezreal.quciksort;

import java.util.Arrays;

/**
 * @author Ezreal
 * @version 2018/4/24.
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] A = new int[]
                { 1, 12, 2, 13, 3, 14, 4, 15, 5, 16, 17, 17, 177, 18, 8, 8, 19 };
        QuickSort quicksort = new QuickSort();
        quicksort.quickSort(A, 0,A.length-1);
        System.out.println(Arrays.toString(A));
    }

    private void quickSort(int[] A, int p, int r){
        if (p > r)
            return;
        int q = partition(A,p,r);
        quickSort(A,p,q-1);
        quickSort(A,q+1,r);

    }

    private Integer partition(int[] A, int p, int r){
        int x = A[r];
        int i = p - 1;
        for (int j = p;j < r;j++ ){
            if (A[j] <= x){
                i = i+1;
                exchange(A,i,j);
            }
        }
        exchange(A,i+1,r);
        return i+1;
    }

    private void exchange(int[] A,int p,int r){
        int temp = A[p];
        A[p] = A[r];
        A[r] = temp;
    }

}
