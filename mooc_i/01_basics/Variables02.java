public class Variables02
{
    public static void main(String[] args)
    {
        // Ne pas confondre = et ==
        int a;
        a = 2; // <- on utilise '=' pour affecter une valeur
        if (a == 2) System.out.print("logic operator!\n");

        // Nous pouvons également écrire:
        a = a + 1; // évaluation de droite à gauche!

        // il est possible de déclarer une constante:
        final double GRAVITY = 9.81; // nous ne pourrons plus modifier la valeur de cette variable

    }
    
}
