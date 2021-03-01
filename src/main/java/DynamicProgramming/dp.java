package DynamicProgramming;

import java.util.Arrays;

public class dp {
    //动态规划问题
    public static void main(String[] args) {

      int[] a= new int[]{1, 2, 5};
        System.out.println("once(a,11) = " + once(a, 1));
    }

//    public static int[][] init(int[][] coins){
//        for (int i = 0; i < coins.length; i++) {
//            coins[0][i]=0;
//        }
//        for (int j = 0; j <coins[0].length; j++) {
//            coins[j][0]=0;
//        }
//        return coins;
//    }
    private static int once(int[] coins, int count){

        int[] dps=new int[count+1];
        Arrays.fill(dps,count+1);
        dps[0]=0;
        //count就是当前总面值，
        for (int i = 1; i <count+1; i++) {
            int min=i;
           for (int coin:coins){
               //还能装下,及一张面值 为 coin的钱装不足 count，将剩下的count向前取最优解（最少的用币量）
               if (i-coin>=0 && dps[i-coin]!=-1){

                    min = Math.min(dps[i], dps[i - coin] + 1);


               }
           }
           dps[i]=min;
        }

      return dps[count];
    }


}
