package dp;

public class StockMarket {
// 交易一次 给一个数组a,第i个元素是股票在第i天的价格
// 在k笔交易情况下 得出最大收益 ZHONG YI ZAI XIAN  互联网客服经理
// 注意：交易必须是买入再卖出
// 【2，4，1】 k=2 ，答案 2，第一天买 第二天卖

//k=1
//状态 1 每天 三个情况 买1 卖2 不动0  =》不动 的两个情况 1，前一天是买了的1 ，2前一天没买0 =》交易次数k=1
    public static int maxPrice(int[] StockPrice){
        //记录状态用数组
        int len=StockPrice.length;
//        int[][][] dp=new int[len][2][1];//len是第几天，2是剩下交易次数*k ，1是现在是否持有
        int[][] dp=new int[len][2];
        for (int i = 0; i < len; i++) {
            if (i-1==-1){
                dp[i][0]=0;//如果第一天没有持有 就是0
                dp[i][1]=StockPrice[i]*-1;//如果第一天持有买入 不卖出 就是-StockPrice[i]
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+StockPrice[i]);

            dp[i][1]=Math.max(dp[i-1][1],-StockPrice[i]);

        }
        return dp[len-1][0];//

    }

    public static void main(String[] args) {
        int[] a={2,4,1};
        int i = maxPrice(a);
        System.out.println("i = " + i);
    }

}
