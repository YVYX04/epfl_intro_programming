public class Variables01
{
    public static void main(String[] args)
    {
        // une variable possède 3 caractéristiques importantes:
        // 1. type (int)
        // 2. indicateur (n)
        // 3. valeur (1)
        int n = 1; // déclaration de variable
        int nCarre; // déclaration de variable sans initialiser sa valeur

        // System.out.println(nCarre); // interdit car la variable est non-initialisée!

        // double: digit number
        double x = 0.3;
        System.out.println(x);

        // on peut déclarer plusieurs variables sur une même ligne
        // (ne pas en abuser car le programme devient moins lisible !)
        int m = 1;
        int p = 1, q = 0;
        double y = 0.1, z;

        // affectation
        m = 19;
    }
}