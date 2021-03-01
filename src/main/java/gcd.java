import java.lang.reflect.Array;
import java.util.ArrayList;

public class gcd {
    public static int gcdTest01(int a,int b){
        if (a==0){
            System.out.println("a = " + a + ", b = " + b);
            return b;
        }
        int r= b % a;
        System.out.println("r = " + r);
        return gcdTest01(b,r);
    }

    public static void main(String[] args) {
        gcdTest01(10,30);

    }
}