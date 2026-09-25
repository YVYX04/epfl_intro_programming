/*
                    +-----------+
                    | Even.java |
                    +-----------+

This program indicates whethere a given integer is:
    (i) positive or negative
    (ii) odd or even
*/
import java.util.Scanner;

public class Even
{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        // banner
        printBanner();

        // input
        int n = in.nextInt(); 

        // boolean test
        boolean even = true;
        boolean positive = true;

        // even
        if(n % 2 != 0) even = false;

        // positive
        if(n < 0) positive = false;

        // answer
        printAnswer(n, even, positive);
    }

    private static void printBanner()
    {
        System.out.print("         +-----------------+        \n" +
                         "         | Number analysis |        \n" +
                         "         +-----------------+        \n" +
                         "Enter an integer: n = "
        );
    }

    private static void printAnswer(int n, boolean even, boolean positive)
    {
        String out = (even ? "even" : "odd") + (positive ? " and positive." : " and negative.");
        System.out.println(n + " is " + out);
        return;
    }
    
}
