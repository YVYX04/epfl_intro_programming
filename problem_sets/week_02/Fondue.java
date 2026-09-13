import java.util.Scanner;

public class Fondue
{
    public static void main(String[] args)
    {
        // init variables
        final int BASE = 4;
        double fromage = 800.0;
        double eau = 2.0;
        double ail = 2.0;
        double pain = 400.0;

        // input
        Scanner keyb = new Scanner(System.in);
        System.out.print("Entrez le nombre de personne(s) conviée(s) à la fondue : ");
        int nbConvives = keyb.nextInt();

        // output
        System.out.println("Pour faire une fondue fribourgeoise pour 3 personnes, il vous faut : \n" + //
                        " - " + fromage * nbConvives / BASE + " gr de Vacherin fribourgeois\n" + //
                        " - " + eau * nbConvives / BASE + " dl d'eau\n" + //
                        " - " + ail * nbConvives / BASE + " gousse(s) d'ail\n" + //
                        " - " + pain * nbConvives / BASE + " gr de pain\n" + //
                        " - du poivre à volonté");   
                        
        keyb.close();
        return;
    }
    
}
