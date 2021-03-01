package sort;

import com.sun.scenario.effect.Merge;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a={1,3,5,-5,0,-1,2,9};
        int[] b={1,3,5,-5,0,-1,2,9};

        int length = a.length;
        int[] re=new int[length];
        int[] merge = Merge(b, re, 0, length - 1);
        int[] ints = merge_sort(a);
        System.out.println(" ints = " + Arrays.toString(ints));
        System.out.println("b = " + Arrays.toString(merge));
    }
    //递归 归并排序
    public static int[] Merge(int[] args, int[] result, int start, int end){
        if (start>=end){
            //当start 和 end递归到最小值，数组大小为1，两值相同
            //return 后 执行判断
            return args;
        }
        int len=end-start;
        //例：short int a=8;a=a>>1;
        //1.a=0 000 1000
        //2.右移一位后：a= 0 000 100
        //3.补0：a=0 000 0100
        //4.化为十进制数：a=4
        int mid=(len>>1)+start;
        int start1=start,end1=mid;
        int start2=mid+1,end2=end;
//        int end1= start +mid;
//        int start2=end1+1;
        Merge(args,result, start1,end1);
        Merge(args,result,start2, end2);
        int k=start;
        while (start1<=end1&&start2<=end2){
            //当两边 的两个 数已经排好，再比较第一个数，小的放在result里面
            //再后移
            result[k++] = args[start1] < args[start2] ? args[start1++] : args[start2++];
        }
        while (start1<=end1){
            //将左边剩下没有比较 排序的 填充到 result
            result[k]=args[start1];
            k+=1;start1+=1;
        }
        while (start2<=end2){
            //将右边剩下没有比较 排序的 填充到 result
            result[k]=args[start2];
            k+=1;start2+=1;
        }
        for (k = start; k <= end; k++){
            args[k] = result[k];
        }

     return args;
    }

//  源
    static int[] merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return null;
        }
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
        return arr;
    }

    public static int[] merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int[] ints = merge_sort_recursive(arr, result, 0, len - 1);
        return ints;
    }
}
