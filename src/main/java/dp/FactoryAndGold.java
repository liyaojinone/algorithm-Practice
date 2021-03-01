package dp;

import sun.security.jgss.GSSCaller;

public class FactoryAndGold {
    public static void main(String[] args) {
        int[] golds = {500, 400, 350, 300, 200};
        int[] persons = {5, 5, 3, 4, 3};
        System.out.println("MaxGold(5,10,golds,persons) = " + MaxGold(5, 10, golds, persons));
    }

    //    有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
//    参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，
// 不能派出一半人挖取一半金矿。要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
//    500 5人 ,400 5人 ,350 3人 ,300 4人 ,200 3人
    public static int MaxGold(int Gs, int Ps, int[] golds, int[] persons) {
        //每座金矿 两种状态 1 挖 2 不挖,
        // Gs总金矿数
        // Ps 总可用人数
        //使用二维数组表示表，纵轴是金矿信息，横轴是人数信息
        int[][] resultTable = new int[Gs + 1][Ps + 1];

        for (int i = 1; i <= Gs; i++) {
            for (int j = 1; j <= Ps; j++) {
                if (j < persons[i - 1]) {
                    resultTable[i][j] = resultTable[i - 1][j];
//                    如果剩下的人数少于 当前金矿的所需人数 （无法操作），则当前黄金的最优解是上一块金矿
                } else {
//                    如果剩下的人数大于 当前金矿的所需人数  要么是这个不挖 挖下个：要么这个挖
                    resultTable[i][j] = Math.max(resultTable[i - 1][j], resultTable[i - 1][j - persons[i - 1]] + golds[i - 1]);
                }


            }

        }
        return resultTable[golds.length][Ps];


    }
}
