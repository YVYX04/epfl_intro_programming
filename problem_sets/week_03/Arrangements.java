/*
Arrangements.java

This problem compute n!/(n-k)! and n!/((n-k)!k!)

WARNING: This program only works for small n.
*/

import java.util.Scanner;

public class Arrangements
{
    public static void main(String[] args)
    {
        // input
        Scanner in = new Scanner(System.in);
        int n, k;
        System.out.print("n = ");
        n = in.nextInt();
        System.out.print("k = ");
        k = in.nextInt();

        // compute
        int p = permutation(k, n);
        int c = combination(k, n);

        // output
        System.out.println("[OUTPUT]: P(n, k) = " + p + ", C(n, k) = " + c);

    }

    private static int permutation(int k, int n)
    {
        // return fact(n)/fact(n - k);
        // best version:
        int p = 1;
        for(int i = n; i > (n - k); --i)
        {
            p *= i; 
        }

        return p;
    }

    private static int combination(int k, int n)
    {
        return fact(n)/(fact(n - k)*fact(k));
    }

    private static int fact(int n)
    {
        if(n <= 1) return 1;
        else return n * fact(n - 1);
    }
}
