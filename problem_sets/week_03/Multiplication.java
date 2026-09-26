/*
Multiplication.java

Print the multiplication tables from 2 to 10.
*/


public class Multiplication {
    public static void main(String[] args)
    {
        for(int i = 2; i < 11; ++i)
        {
            printTitle(i);
            for(int j = 1; j < 11; ++j)
            {
                System.out.println("> " + i + " x " + j + " = " + (i*j));
            }
        }
    }

    private static void printTitle(int n)
    {
        System.out.println("\n-- Multiplication table of " + n + " --");
    }
}
