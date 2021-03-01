public class ReverseCode {
    public static void main(String[] args) {
        System.out.println("reverse(-12357) = " + reverse1(-12357));
    }

    /**1.整数反转
    * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    *   示例 1:   输入: 123     输出: 321
    *    示例 2:   输入: -123    输出: -321
    *   示例 3:   输入: 120     输出: 21
    * */
    public static int reverse(int a){
        long x=0;
        while (a!=0){
           x=x*10+a%10; //x=1 10+2=12 12*10+3=123
           a=a/10; //a=32 a=3 a=0
        }
        return (int)x==x?(int)x:0;
    }


    public static  int reverse1(int a){
        int x=0;
        while (a!=0){
            x=x*10+a%10;
            a=a/10;
        }
        return x;
    }
}

