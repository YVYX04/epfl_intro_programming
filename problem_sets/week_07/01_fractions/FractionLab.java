/**
 * @author : Yvan Richard
 * @version : 1.0.0
 * FractionLab
 * This class compute harmonic numbers: \sum_{k = 1}^{n} (1 / k)
 */

public class FractionLab
{
    // ___ member variables ___
    private Fraction fraction;
    private int n;

    // ___ CONSTRUCTORS ___
    /**
     * We build the harmonic series of index n and write the result in fraction.
     * @param n (int):  the final index of the sum
     */
    public FractionLab(int n)
    {
        // if n <= 0, we print an error message and compute H(1) = 1.
        if(n <= 0) {
            System.out.println("Error: Fraction number must be positive");
            this.n = 1;
            fraction = new Fraction(1, 1);
            return;
        }

        // compute 1 + 1/2 + 1/3 + (...) + 1/n
        this.n = n;
        Fraction f = new Fraction(1, 1);
        for(int i = 2; i <= n; ++i) {
            Fraction temp = new Fraction(1, i);
            f = f.add(temp);
        }
        fraction = f;
    }

    // ___ HELPERS ___
    public String toString()
    {
        return new String("H_" + n + " = " + fraction.toString());
    }
}
