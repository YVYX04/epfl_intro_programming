/**
 * @author: Yvan Richard
 * @version: 1.0.0
 * Fraction
 * This class creates a very simple object to handle fraction
 */

public class Fraction
{
    // member variables
    private final long n;
    private final long d;

    // ___ CONSTRUCTORS ___
    /**
     * Basic constructor for the fraction class. Enforces that gcd(n, d) = 1.
     * Zero is stored as 0 / 1.
     * d >= 0.
     * @param n numerator of the fraction.
     * @param d denominator of the fraciton.
     */

    public Fraction(long n, long d)
    {
        // forbid division by 0
        if(d == 0)
        {
            System.out.println("Error: zero denominator, fraction set to 0");
            this.n = 0;
            this.d = 1;
            return;
        }

        // base cases
        if(n == 0 && d != 0)
        {
            this.n = 0;
            this.d = 1;
            return;
        }

        // find the greatest common divisor:
        long gcd = gcd(n, d);

        // enforce d > 0
        if((n >= 0 && d < 0) || (n < 0 && d < 0)) // 3/-2 -> -3/2
        {
            this.n = -(n / gcd);
            this.d = -(d / gcd);
        } else // d > 0
        {
            this.n = (n / gcd);
            this.d = (d / gcd);
        }
    }

    /**
     * Building an integer
     * @param n : the fraction will be n / 1
     */
    public Fraction(long n)
    {
        this(n, 1);
    }

    /**
     * Default constructor, fraction init at 0.
     */
    public Fraction()
    {
        this(0, 1);
    }

    /**
     * Copy constructor
     */
    public Fraction(Fraction other)
    {
        this(other.n, other.d);
    }

    // ___ GETTERS ___
    public long getNumerator()
    {
        return n;
    }
    public long getDenominator()
    {
        return d;
    }

    // ___ OPERATORS ___
    /**
     * Return the addition of two fractions q1.add(q2) = q1 + q2.
     * @param o : fraction to be added
     * @return this + o
     */

    public Fraction add(Fraction o)
    {
        long num = (n * o.d + o.n * d);
        long den = d * o.d;
        return new Fraction(num, den);
    }

    /**
     * Substract two fractions.
     * @param o : fraction to be substracted
     * @return this - o
     */
    public Fraction subtract(Fraction o)
    {
        long num = (n * o.d - o.n * d);
        long den = d * o.d;
        return new Fraction(num, den);
    }

    /**
     * Multiply two fractions.
     * @param o : fraction to be multiplied by.
     * @return this x o
     */
    public Fraction multiply(Fraction o)
    {
        return new Fraction(n * o.n, d * o.d);
    }

    /**
     * Divide two fractions.
     * @param o : fraction to be divided by.
     * @return this / o
     */
    public Fraction divide(Fraction o)
    {
        // prevent division by 0
        if(o.n == 0) return null;
        return new Fraction(n * o.d, d * o.n);
    }

    /**
     * Return the reciprocal of a fraction a/b -> b/a
     * @return 1 / this
     */
    public Fraction reciprocal()
    {
        if(n == 0) return null;
        return new Fraction(d, n);
    }

    /**
     * Compare two fractions exactly. No double allowed.
     * @param o : fraction against which we compare.
     * @return true if this < o.
     */
    public boolean isLessThan(Fraction o)
    {
        if(o == null) return false;
        return (n * o.d < o.n * d);
    }

    /**
     * Check if two fraction are equals.
     * @param o : fraction against which we compare.
     * @return true if this == o
     */
    public boolean equals(Fraction o)
    {
        if(o == null) return false;
        return ((n == o.n) && (d == o.d));
    }

    // ___ CONVERSIONS ___
    public double toDouble()
    {
        return ((double) n / d);
    }



    // ___ HELPERS ___
    /**
     * Return the greatest common divisor of two long numbers a and b
     * @param a : first number
     * @param b : second number
     * @return the greatest common divisor of a, b; gcd(4, 6) = 2.
     */
    private long gcd(long a, long b)
    {
        // enforce a >= 0, b >= 0
        if(a < 0) { a = -a;}
        if(b < 0) { b = -b; }

        // enforce a >= b
        if(a < b)
        {
            long tmp = a;
            a = b;
            b = tmp;
        }

        // compute remainder of a / b
        long remainder = a % b;

        // if the remainder == 0 -> a = q * b (q \in N)
        if (remainder == 0) { return b; }
        else return gcd(b, remainder); 
    }

    public String toString()
    {
        if(d != 1) return new String(this.n + "/" + this.d);
        else return new String("" + n);
    }

    
}
