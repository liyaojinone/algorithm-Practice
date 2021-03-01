package sort;

import java.util.Arrays;

public class insertSort {
    //插入排序
    public static void main(String[] args) {
        int[] ints = new int[]{3,9,-1,10,-2};
        insert(ints);
    }
    public static void insert(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            //记录插入的值
            int i1 = arr[i];
            int index=i-1;
            while (index >= 0 && i1<arr[index]){
                //后移[3, 9, -1, 10, -2]==>[3, 9, 9, 10, -2]
                arr[index+1]=arr[index];
                //要进行逐个比较，index索引向前移动
                index--;
                System.out.println(" arr= " +i+ Arrays.toString(arr));
            }
            //此处的index--进入while判断后再退出，所以要+1
            arr[index+1]=i1;
            System.out.println(" arr= " + Arrays.toString(arr));
        }
    }
}
