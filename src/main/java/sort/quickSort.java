package sort;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
      int[] a={1,3,5,-5,0,-1,2,9};
        int[] quick = quickt(a, 0, a.length - 1);
        System.out.println("quick = " + Arrays.toString(quick));
    }
    public static int[] quick(int[] args, int low, int high){
        int left=low;
        int right=high;
        int p=args[low];
        while (left<right){
           while (left<right&&args[right]>p){
               //如果右边大于基值，则左移
               right--;
           }
           while (left<right&&args[left]<p){
               //如果左边小于基值，则右移
               left++;
           }

           if (left<right&&args[right]==args[left]){
               left++;
           }else {
               int temp=args[right];
               args[right]=args[left];
               args[left]=temp;
           }
        }//
        //判断 左边 基数的 右边 是否还有数 ，有就进行排序
        //此处均不包括 基数 的左边 和 右边
        if (left>low+1){
             args=quick(args, low, left-1 );
        }
        if (right<high-1){
            args = quick(args, right+1, high);
        }
        return args;
    }

    public static int[] quickt(int[] args,int low,int high) {
    int left=low;
    int right=high;
    int p=args[left];
    while (left<right){
        while (left<right&&args[left]<p){
            left++;
        }
        while (left<right&&args[right]>p){
            right--;
        }
        if (left<right&&args[right]==args[left]){
            left++;
        }else{
            int c=args[right];
            args[right]=args[left];
            args[left]=c;
            //再循环时args[right]变小了，args[left]变大了
        }

    }
    if (left>low+1){
        quickt(args,low,left-1);
    }
    if (right<high-1){
        quickt(args,right+1,high);
    }
    return  args;

    }

}




