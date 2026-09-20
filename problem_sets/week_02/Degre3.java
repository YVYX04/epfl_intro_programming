import java.util.Scanner;


public class Degre3
{
    public static void main(String[] args)
    {
        // input
        int a, b, c;
        double x;
        Scanner keyb = new Scanner(System.in);
        System.out.print("Entrez a (int) : ");
        a = keyb.nextInt();
        System.out.print("Entrez b (int) : ");
        b = keyb.nextInt();
        System.out.print("Entrez c (int) : ");
        c = keyb.nextInt();
        System.out.print("Entrez x (double) : ");
        x = keyb.nextDouble();

        // compute polynome value
        // we use the form d1 * x^3 + d2 * x^2 + d3
        int ab = (a + b);
        double d1 = ab / 2.0;
        double d2 = ab * ab;
        double d3 = ab + c;

        double y = d1 * (x * x * x) + d2 * x * x + d3;

        // output
        System.out.println("La valeur du polynome est : " + y);
        keyb.close();
        return;
    }
    
}
