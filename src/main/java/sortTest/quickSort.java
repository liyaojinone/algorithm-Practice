package sortTest;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
       int[] a={-23,5,23,1,5,20,-1};
        int[] sort = sort(a, 0, 6);
        System.out.println("sort(a,0,5) = " + Arrays.toString(sort));
    }

    public  static  int[] sort(int[] arr,int low,int hight){
        int left=low;
        int right=hight;
        int pin=arr[low];
        while (left<right){
            while (arr[left]<pin&&left<right){
                left++;
            }
            while (arr[right]>pin&&left<right){
                right--;
            }
            //前面两while就是为了 得到：左边比pin大的index，右边比pin小的index
            if(left<right&&arr[left]==arr[right]){
                left++;
            }else {
                int temp=arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
            }
            //if语句中分为：arr[left]==arr[right]（特殊情况 ，两边的index对应的值可能相等）， 不等于其他情况

        }
        if (hight-1>right){
            arr=sort(arr,right+1,hight);
        }
        if (low+1<left){
            arr=sort(arr,low,left-1);
        }
        return arr;




    }
}
