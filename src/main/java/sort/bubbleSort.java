package sort;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] ints = new int[]{3,9,-1,10,-2};
        bubble(ints);

    }
    public static void bubble(int[] arr){
        //《1》冒泡排序是i与i+1比较，
        //《2》max值后移，在《1》
        //《3》最大值在最后面
        int tamp=0;
        boolean flag=false;
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = 1; j < arr.length; j++) {
                int i2 = arr[j];
                int i1 = arr[j - 1];
                if (i1>i2){
                    flag=true;
                    arr[j-1]=i2;
                    tamp=i1;
                    arr[j]=tamp;
                }

                System.out.println(Arrays.toString(arr));
            }
            if (!flag){
                break;
            }else {
                flag=false;
            }
            System.out.printf("++++++++++%d+++++++++\n",i);
            System.out.println("result:"+Arrays.toString(arr));
        }
    }
}
