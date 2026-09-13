import java.util.Scanner;

public class Variables03
{
    public static void main(String[] args)
    {
        // swap
        int a = 1, b = 0;
        int tmp = a;
        a = b;
        b = tmp;
        if(a == 0 && b == 1) System.out.println("The values have been swaped.");

        // taking input
        Scanner keyb = new Scanner(System.in);
        System.out.print("Enter an int: ");
        int n = keyb.nextInt();
        System.out.print("Enter a double: ");
        double x = keyb.nextDouble();

        // take a string as input (BEWARE!)
        System.out.print("Enter a string: ");
        // String s1 = keyb.nextLine(); will not work because we entered a '\n' before
        keyb.nextLine(); // read the '\n'
        String s1 = keyb.nextLine();


    }    
}
