import java.util.Scanner;

public class RosesBlanches
{
    public static void main(String[] args)
    {
        // const
        final int COFFEE_PRICE = 2;
        final int FLASH_PRICE = 4;
        final int TICKET_PRICE = 3;

        // input
        Scanner in = new Scanner(System.in);
        System.out.print("Enter CHF amount (int) : ");
        int x = in.nextInt();

        // compute
        int books = (3 * x) / 4;
        x -= books;

        int equal_split = x / 3;
        x -= (equal_split * 3);
        int n_coffee = equal_split / COFFEE_PRICE;
        x += equal_split % COFFEE_PRICE;
        int n_flash = equal_split / FLASH_PRICE;
        x += equal_split % FLASH_PRICE;
        int n_ticket = equal_split / TICKET_PRICE;
        x += equal_split % TICKET_PRICE;



        System.out.println(
            "(" +
            books + ", " +
            n_coffee + ", " +
            n_flash + ", " +
            n_ticket + ", " +
            x + ")."
        );
        
    }
}
