package Find;

import java.util.Arrays;

public class FibonacciSearch {
    private static final int Max=20;
    public static void main(String[] args) {
        int[] ints = {0, 16, 24, 35, 47, 59, 62, 73, 88, 99};
        int index = fibonacci(ints, 99);
        System.out.println("index = " + index);


    }
    /**开始将k值与第F(k-1)位置的记录进行比较(及mid=low+F(k-1)-1),比较结果也分为三种
　　1）相等，mid位置的元素即为所求
　　2）>，low=mid+1,k-=2;
　　  说明：low=mid+1说明待查找的元素在[mid+1,high]范围内，
            k-=2 说明范围[mid+1,high]内的元素个数为n-(F(k-1))= Fk-1-F(k-1) = Fk-F(k-1)-1 = F(k-2)-1 个，
            所以可以递归的应用斐波那契查找。
　　3）<，high=mid-1,k-=1。
　　    说明：low=mid+1说明待查找的元素在[low,mid-1]范围内，k-=1 说明范围[low,mid-1]内的元素个数为F(k-1)-1个，
              所以可以递归 的应用斐波那契查找。
    *
     */
    public static int[] fibo(){

        int[] f = new int[Max];
        f[0]=1;
         f[1]=1;
         int x=2;
        while (Max>x){
          f[x]=f[x-1]+f[x-2];
          x+=1;
         }

        return f;
    }

    public static int fibonacci(int[] args,int obj){
         int low=0;
         int high=args.length-1;
         int k=0;
         int mid=0;

         int[] f = fibo();
        while (high>f[k]-1){
            k++;
        }
        int[] temp = Arrays.copyOf(args, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            //将超过arg数组大小的 所有值 置为 args最后一个值
            temp[i] = args[high];
        }
        while (low<=high){
            //mid只是一个索引 = 斐波那契数列的位置-1
           mid=low+f[k-1]-1;
           if (obj<temp[mid]){
               high=mid-1;
               k-=1;
           }
           else if (obj>temp[mid]){
               low=mid+1;
               k-=2;
           }
           else {
               if (high>=mid){
                   return mid;
               }else {
                   return high;
               }
               //找不到
           }
        }
        return -1;


    }
}
