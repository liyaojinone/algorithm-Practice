package sort;

import java.util.Arrays;

public class selectSort {
    public static void main(String[] args) {
        int[] ints = new int[]{3,9,-1,10,-2};
        select0(ints);

    }
    public static void select(int[] arr){
        //《1》选择排序是i与i(i<n<len)逐个比较，
        //《2》min值在第一位，在i+1 执行《1》
        //《3》最小值在最前面
        int temp;
        for (int i = 0; i < arr.length ; i++) {
            //当前值
            for (int j = i; j < arr.length-1 ; j++) {
                if (arr[i]>arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[i];
                    arr[i]=temp;
                }
                System.out.println("result:"+ Arrays.toString(arr));
            }
            System.out.println("result:"+ Arrays.toString(arr));
        }
    }

    public static void select0(int[] arr){
        int temp;
        int min;
        for (int i = 0; i < arr.length; i++) {
            min=i;
            for (int j = i+1; j <arr.length ; j++) {
                 if (arr[min]>arr[j]){
                     min=j;
                 }
            }
            if (i!=min){
                 temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            System.out.println("result:"+ Arrays.toString(arr));
        }


    }

    public  static void select1(int[] arr){
        int min;
        int temp;
        for (int i=0;i<arr.length;i++){
            min =i;
            for (int j = i+1; j <arr.length-i ; j++) {
                if (arr[j]<arr[min]){
                    min=j;
                }
            }
            if (min!=i){
                temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;

            }

        }



    }
}

