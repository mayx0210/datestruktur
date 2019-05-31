package com.myx.datwstruct;

public class SparseArrayDemo {
    public static void main(String[] args) {
        int rows = 11;
        int cols = 11;

        int[][] cheepMap1 = new int[rows][cols];
        cheepMap1[1][2] = 1;
        cheepMap1[2][3] = 2;
        
        for (int i = 0;i <cheepMap1.length;i++){
            for (int j = 0; j < cheepMap1[i].length; j++) {
                System.out.print(cheepMap1[i][j]);
            }
            System.out.println();
        }
    }
}
