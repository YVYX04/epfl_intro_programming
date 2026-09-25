import java.util.Scanner;

public class Coffee
{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        // input
        System.out.print("Select your product (1 - 3): ");
        int choice = in.nextInt();

        // switch
        switch(choice)
        {
            case 1:
                System.out.println("Coffee - 3 CHF");
                break;
            case 2:
                System.out.println("Tea - 2 CHF");
                break;
            case 3:
                System.out.println("Water - 1 CHF");
                break;
            default:
                System.out.println("Invalid choice.");
        }

        return;
    }
}
