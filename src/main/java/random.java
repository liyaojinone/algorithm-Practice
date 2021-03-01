import jdk.nashorn.internal.ir.CallNode;
import res.StdDraw;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;

public class random {
    public static void main(String[] args) {
        int S=20;
       int[] ints=new int[S];
        Random random1 = new Random(1);
        for (int i = 0; i < S; i++) {
            int i1 = random1.nextInt(10);
            ints[i]=i1;
        }
        System.out.println("ints = " + Arrays.toString(ints));
    }


}
