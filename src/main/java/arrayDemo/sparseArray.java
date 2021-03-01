package arrayDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class sparseArray {
    public static void main(String[] args) {
        int[][] ints = new int[12][11];
        ints[1][2]=1;
        ints[2][4]=2;
        ints[3][10]=5;
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i])+'\t');
        }
        sparseCalculation sparseCalculation = new sparseCalculation();
        int[][] ints1 = sparseCalculation.makeSparseArray(ints);
        System.out.println();
        for (int i = 0; i < ints1.length; i++) {
            System.out.println(Arrays.toString(ints1[i])+'\t');
        }
    }



}
