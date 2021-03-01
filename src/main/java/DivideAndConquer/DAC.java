package DivideAndConquer;

public class DAC {
    //汉诺塔 问题 三 个 塔 a,b,c 将 a上面的盘移动到c

    public static void main(String[] args) {
        once(5,'A','B','C');
    }
    private static void once(int num,char a,char b,char c){
        //1，如果只有一个盘，a->c结束
        if (num==1){
            //关键部分 ：当问题细分到 1 时，执行后会回退到 上一次递归函数执行的下一步，此处还是 子问题
            // 按照子问题 的解决方法进行处理
            System.out.println(" 第YI个盘从"+a+"->"+c);
        }else {
            //将 a塔上面的盘分成 2 个部分，上面 部分移动到 b
            once(num-1,a , c , b);
            //子问题的解决方法 将 b上面的盘移动到c
            System.out.println(" 第"+num+"个盘从"+a+"->"+c);
            // 将 b上面的盘移动到c
            once(num-1, b , a, c);
        }

    }
}
