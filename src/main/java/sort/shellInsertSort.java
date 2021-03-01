package sort;

import java.util.Arrays;

/**
 * @author jion
 */
public class shellInsertSort {
    public static void main(String[] args) {
        int[] ints ={8,9,1,7,2,3,5,4,6,0};
        int[] shell = shell(ints);
        System.out.println("shell = " + Arrays.toString(shell));
//        System.out.println("shell(ints) = " + Arrays.toString(shell(ints)));
//        selectSort.select(shell);
    }

    public static int[] shell(int[] ints){
        int length = ints.length;
        int[] args = ints;

         for (int len=length/2; len>0 ; len/=2) {
            for (int i = len; i < length; i++) {
                //这里起始值为len，也是可以从终值中减len
                int i1=args[i];
                int j=i;//为什么这里不能用i 因为需要将指针i后移len，这样会改变i=值，改变后i++就不是递归后移了
                if (i1<args[j-len]){
                    for (;j>=len&&i1<args[j-len];j-=len){
                        args[j]=args[j-len];
                    }
//                此时 arg[j]已经上一个for中的arg[j-len]了
                    args[j]=i1;
                }
            }
        }
     return args;
    }
}
