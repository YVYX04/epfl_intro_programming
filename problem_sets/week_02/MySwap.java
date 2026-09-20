import java.util.Scanner;

public class MySwap
{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        // input
        int x, y;
        System.out.print("Enter x (int): ");
        x = in.nextInt();
        System.out.print("Enter y (int): ");
        y = in.nextInt();

        // intermediate print
        System.out.println("Before permutation: x = " + x + ", y = " + y);

        // permute
        int t = x;
        x = y;
        y = t;

        // final print
         System.out.println("After permutation: x = " + x + ", y = " + y);

        
    }
    
}
