package arrayDemo;

import java.util.ArrayList;

public class sparseCalculation {
    private static ArrayList<sparse> conversionRow (int[][] ints){
        int Column=ints.length;
        ArrayList<sparse> sparses = new ArrayList<>();
        int row =ints[Column-1].length;
        for (int i = 0; i <Column; i++) {
            for (int j = 0; j <row ; j++) {
                if(ints[i][j]!=0){
                    sparse sparse = new sparse(i,j,ints[i][j]);
                    sparses.add(sparse);
                }
            }
        }
        return sparses;
    }
    public int[][] makeSparseArray(int[][] ints){
        ArrayList<sparse> sparses = conversionRow(ints);
        int resultRow  = sparses.size();

        int[][] sparseArray = new int[resultRow + 1][3];
        sparseArray[0]= new int[]{ints.length, ints[1].length, resultRow};
        for (int i = 1; i < resultRow+1; i++) {
            sparse sparse = sparses.get(i - 1);
            sparseArray[i][0]= sparse.getRow();
            sparseArray[i][1]=sparse.getColumn();
            sparseArray[i][2]=sparse.getResult();

        }
        return sparseArray;

    }
}
