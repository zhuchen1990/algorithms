package com.ezreal.quciksort;

import java.util.Arrays;

/**
 * @author ezreal
 */
public class Test {
    public static void main(String[] args) {
        int[] A = new int[]
                { 1, 12, 2, 13, 3, 14, 4, 15, 5, 16, 17, 17, 177, 18, 8, 8, 19 };
        Test.quickSorts(A,0,A.length-1);
        System.out.println(Arrays.toString(A));

    }

    private static void  quickSorts(int[] A, int p, int r){
       if(p > r){
           return;
       }
       int q = partitions(A,p,r);
       quickSorts(A,p,q-1);
       quickSorts(A,q+1,r);

    }

    private static Integer partitions(int[] A, int p, int r){
        int x = A[r];
        int i = p - 1;
        for (int j = p;j<r;j++){
            if (A[j] <= x){
                i++;
                exchanges(A,i,j);
            }
        }
        exchanges(A,i+1,r);
        return i+1;
    }

    private static void exchanges(int[] A,int p,int r){
        int temp = A[p];
        A[p] = A[r];
        A[r] = temp;
    }
}
