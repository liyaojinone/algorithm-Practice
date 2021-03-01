package dp;

public class ArrayDp {

    public static void main(String[] args) {
        int[] a={3,6,8,1,10,4};
        System.out.println("MaxArray(a) = " + MaxArray(a));

    }
//在正数组中取出一个或多个不相邻数，使其和最大，即找到max(不相邻元素组成的子数组)。
    public static int MaxArray(int[] arr){
        int[] opt=new int[arr.length];
        opt[0]=arr[0];
        opt[1]=Math.max(arr[0],arr[1]);
        for (int i = 2; i <arr.length; i++) {
            //得到最大值 选择当前数的；不选择当前值
//            opt[i]=Math.max(arr[i]+arr[i-2],arr[i-1]);
            int a = opt[i-2] + arr[i];
            int b = opt[i-1];
            opt[i] = Math.max(a, b);
        }

        return opt[arr.length-1];
    }
}
