/*
MeanMaxMin.java

The user enters n integers and we must report the mean, maximum value, and
minimum value.
*/
import java.util.Scanner;

public class MeanMaxMin {
    public static void main(String[] args)
    {
        // input
        Scanner in = new Scanner(System.in);
        int n = 0;
        System.out.print("N = ");
        n = in.nextInt();

        double mean = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; ++i)
        {
            System.out.print("> Enter n_" + i + ": ");
            int x = in.nextInt();
            if(x > max) max = x;
            if(x < min) min = x;
            mean += x;
        }

        mean /= n;
        System.out.println("\n[OUTPUT] mean: " + mean + ", max: " + max + ", min: " + min);
    }
}
