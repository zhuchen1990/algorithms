package com.ezreal.lcs;


/**
 * @author Ezreal
 * @version 2018/5/4.
 * @deprecated 最长子序列问题
 */
public class Lcs {
    public static void main(String[] args) {
        String[] x ={"A", "B", "C", "B", "D", "A", "B"};
        String[] y ={"B", "D", "C", "A", "B", "A"};
        lcslength(x,y);
    }

    private static void lcslength(String[] x, String[] y){
        int m = x.length+1;
        int n = y.length+1;
        char[][]b = new char[m][n];
        int[][]c = new int[m][n];
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (x[i-1].equals(y[j-1])){
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = '↖';
                }else if (c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = '↑';
                }else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = '←';
                }
            }
        }
        System.out.print("\t");
        for (int i= 0;i<y.length;i++){
            System.out.print(y[i]+"\t");
        }
        print(b);
        System.out.println();
        print(c);
        System.out.println();
        print(b,x,x.length,y.length);

    }

    private static void print(int[][]a){
        for (int i = 0;i< a.length;i++){
            for (int j = 0; j<a[i].length;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
    private static void print(char[][]a){
        for (int i = 0;i< a.length;i++){
            for (int j = 0; j<a[i].length;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static void print(char[][] b, String[] x, int i, int j){
        if (i == 0 || j == 0){
            return;
        }
        if (b[i][j] == '↖'){
            print(b,x,i-1,j-1);
            System.out.print(x[i-1]+"\t");
        }else if (b[i][j] == '↑'){
            print(b,x,i-1,j);
        }else {
            print(b,x,i,j-1);
        }
    }
}
