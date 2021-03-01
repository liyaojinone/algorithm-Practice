package sort;

import java.util.Arrays;

public class radixSort {
    //基数排序
    public static void main(String[] args) {
        int[] a={1,3,5,7,0,6,24,90};
        System.out.printf("位数为：%d", Max(a));
        radix(a);
        System.out.println("a = " + Arrays.toString(a));

    }
    public static void radix(int[] args){
        //次方法 不适用于负数，如果是负数应该再加 10 个桶
        //定义十个桶
        int[][] buckets = new int[10][args.length];
        //记录每个桶当前填入的值的个数
//        int[] bucketIndex = new int[10];
        //考虑负数0-9正数 10-19负数
        int[] bucketIndex = new int[20];
        //得到arr中最多位数（max）值的位数，即为循环数
        int max = Max(args);
        for (int i = 0, dev = 1; i <max; i++,dev*=10) {
            //从个位 到 十位 ，
            for (int a = 0; a <args.length ; a++) {
                //得到要填入桶的索引
                int indexBucket=(args[a]/dev) %10;
                buckets[indexBucket][bucketIndex[indexBucket]]=args[a];
                bucketIndex[indexBucket]++;
            }
            int index =0;
            for (int c = 0; c <bucketIndex.length ; c++) {
                //如果桶有数据遍历
                if (bucketIndex[c]!=0){
                    //循环
                    for (int j = 0; j < bucketIndex[c]; j++) {
                        args[index++]=buckets[c][j];
                    }
                }
                bucketIndex[c]=0;
            }
        }



    }

    private static int Max(int[] a) {
        int max=a[0];
        int len=0;
        for (int i = 0; i <a.length ; i++) {
            if (max<a[i]){
                max=a[i];
            }
        }
        if (max!=0) {
            for (int t = max; max != 0; max /= 10) {
                len++;
            }
        }else {
            len=1;
        }
        return len;
    }
}
