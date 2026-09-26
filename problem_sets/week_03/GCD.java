/*
GCD.java
This program compute the greatest common divisor between two positive integers.
*/

import java.util.Scanner;

public class GCD
{
    public static void main(String args[])
    {
        // input
        Scanner in = new Scanner(System.in);
        int a, b;
        System.out.print("a = ");
        a = in.nextInt();
        System.out.print("b = ");
        b = in.nextInt();

        // compute
        int sol = gcd(a, b);

        // out
        System.out.println("[OUTPUT]: " + sol);
    }

    private static int gcd(int a, int b)
    {
        // 1. a == b
        if(a == b) return a;

        // 2. enforce a > b
        if(a < b)
        {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 3. Euclid's algorithm with recurrence
        return gcd(a - b, b);
    }

}
