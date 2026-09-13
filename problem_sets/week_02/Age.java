import java.util.Scanner;

public class Age
{
    public static void main(String[] args)
    {
        // init scanner
        Scanner keyb = new Scanner(System.in);

        // init variable(s)
        final int CURRENT_YEAR = 2026;

        // input
        int age;
        System.out.println("Donnez votre age : ");
        age = keyb.nextInt();

        // output
        int annee = CURRENT_YEAR - age;
        System.out.println("Votre annee de naissance est : " + annee);

        // close
        keyb.close();
        return;
        
    }
    
}
