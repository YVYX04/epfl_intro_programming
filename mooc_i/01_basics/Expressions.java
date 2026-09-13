public class Expressions
{
    public static void main(String[] args)
    {
        // nous devons respecter le type des variables
        double x1 = 1.5;
        // int n = 2 * x1; // throw error

        // erreur de débutant :C
        double x2 = 2 / 4; // on divise deux entiers donc on utilise la division entière!
        System.out.println("x2: " + x2); // > "x2: 0.0"
        double x3 = 2.0 / 4;
        System.out.println("x3: " + x3); // > "x3: 0.5"

        // some interesting operator
        // guess the output:
        int i1 = 1;
        int i2 = 2;
        int val = ((i1++) + (++i2)) % 2;
        val+=i1;
        System.out.println("val: " + val);

        int n_carré = 1;
    }
    
}
