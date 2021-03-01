package dp;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("MinStairs(10) = " + MinStairs(10));
    }
//    您正在爬楼梯。到达顶部需要n步。每次您可以爬1或2步。您可以通过几种不同的方式登顶？
//    注意：给定n将为正整数。范例1：
    public static int MinStairs(int n){
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        memo[0]=1;
        memo[1]=1;
        for (int i = 0; i <= n; i++) {
            if (memo[i] == -1){
                //没走没有计算最多
                memo[i]=memo[i-1]+memo[i-2];
            }
        }


     return memo[n];
    }
}
