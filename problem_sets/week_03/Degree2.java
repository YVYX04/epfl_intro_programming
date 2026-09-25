/*
                    +--------------+
                    | Degree2.java |
                    +--------------+

Solves the quadratic equation

    p(x) = a*x^2 + b*x + c = 0          a, b, c in R

Interactive command line interface: type the three coefficients, read
the answer, repeat until you say no.

The file is split into two halves that never mix:

  - the USER INTERFACE methods talk to the terminal and compute nothing;
  - the SOLVING methods compute and print nothing. They hand the answer
    back as a String, and main() decides where it goes.

Keeping the two apart means the solver can be reused (a test, a GUI, a
web page) without dragging System.out along with it.

Degenerate inputs are part of the case analysis, not accidents:
a = 0 is a linear equation, a = b = 0 is either "no roots" (c != 0) or
"every x is a root" (c = 0).
*/

import java.util.Locale;
import java.util.Scanner;

public class Degree2
{
    /* Relative tolerance: a quantity counts as zero when it is this small
       compared to the magnitude of the numbers it was built from. A fixed
       absolute threshold such as 1e-16 is meaningless for coefficients
       around 1e6, and far too coarse for coefficients around 1e-6. */
    private static final double TOL = 1e-12;

    public static void main(String[] args)
    {
        /* Locale.ROOT so that a decimal is always written "1.5" and never
           "1,5", whatever the machine the program runs on. */
        Scanner in = new Scanner(System.in).useLocale(Locale.ROOT);

        printBanner();

        boolean again;
        do
        {
            double a = readDouble(in, "a");
            double b = readDouble(in, "b");
            double c = readDouble(in, "c");

            System.out.println();
            System.out.println("  " + equation(a, b, c));
            System.out.println("  " + solve(a, b, c));
            System.out.println();

            again = askYesNo(in, "Solve another one?");
        }
        while (again);

        System.out.println("Bye.");
        in.close();
    }

    /* ------------------------------------------------------------------
       User interface: reads and writes, computes nothing.
       ------------------------------------------------------------------ */

    private static void printBanner()
    {
        System.out.println();
        System.out.println("  +-----------------------------------+");
        System.out.println("  |  Degree2  --  quadratic solver    |");
        System.out.println("  +-----------------------------------+");
        System.out.println("  Coefficients of  a*x^2 + b*x + c = 0");
        System.out.println();
    }

    /* Keeps asking until the answer really is a number, instead of
       crashing on the first typo. */
    private static double readDouble(Scanner in, String name)
    {
        while (true)
        {
            System.out.print("  " + name + " = ");

            if (!in.hasNext())
            {
                System.out.println();
                System.out.println("Input ended. Bye.");
                System.exit(0);
            }

            if (in.hasNextDouble())
            {
                return in.nextDouble();
            }

            String junk = in.next();
            System.out.println("  \"" + junk + "\" is not a number."
                               + " Examples: 2, -1.5, 1e3");
        }
    }

    private static boolean askYesNo(Scanner in, String question)
    {
        while (true)
        {
            System.out.print(question + " [y/n] ");

            if (!in.hasNext())
            {
                System.out.println();
                return false;
            }

            String answer = in.next().toLowerCase();

            if (answer.equals("y") || answer.equals("yes"))
            {
                return true;
            }
            if (answer.equals("n") || answer.equals("no"))
            {
                return false;
            }

            System.out.println("  Please answer y or n.");
        }
    }

    private static String equation(double a, double b, double c)
    {
        return "p(x) = " + fmt(a) + "x^2 " + signed(b) + "x " + signed(c) + " = 0";
    }

    /* "+ 3" or "- 3", so the equation never reads "+ -3". */
    private static String signed(double x)
    {
        return (x < 0 ? "- " : "+ ") + fmt(Math.abs(x));
    }

    /* 2 rather than 2.0, and 0 rather than -0.0. */
    private static String fmt(double x)
    {
        double v = (x == 0.0) ? 0.0 : x;

        if (v == Math.rint(v) && Math.abs(v) < 1e15)
        {
            return String.format(Locale.ROOT, "%.0f", v);
        }
        return String.valueOf(v);
    }

    /* ------------------------------------------------------------------
       Solving: computes, prints nothing.
       ------------------------------------------------------------------ */

    private static String solve(double a, double b, double c)
    {
        /* One decision, taken once: is this actually a quadratic? The two
           worlds are exclusive branches, so the linear case can never fall
           through into a division by 2a. */
        if (isNegligible(a, Math.abs(b) + Math.abs(c)))
        {
            return solveLinear(b, c);
        }
        return solveQuadratic(a, b, c);
    }

    private static String solveLinear(double b, double c)
    {
        if (isNegligible(b, Math.abs(c)))
        {
            if (isNegligible(c, 1.0))
            {
                return "a = b = c = 0: every x is a root.";
            }
            return "a = b = 0 and c != 0: the equation reads "
                   + fmt(c) + " = 0, so there is no root.";
        }
        return "a = 0, so the equation is linear. One root: x = " + fmt(-c / b);
    }

    private static String solveQuadratic(double a, double b, double c)
    {
        double delta = b * b - 4 * a * c;

        /* delta is a difference of two terms of size b*b and 4ac, so that
           sum is the natural yardstick for "is delta zero?". */
        double scale = Math.abs(b * b) + Math.abs(4 * a * c);

        if (isNegligible(delta, scale))
        {
            return "delta = 0. Double root: x = " + fmt(-b / (2 * a));
        }

        if (delta < 0)
        {
            double re = -b / (2 * a);
            double im = Math.sqrt(-delta) / (2 * Math.abs(a));
            return "delta < 0. No real root, complex pair: x = "
                   + fmt(re) + " +/- " + fmt(im) + "i";
        }

        /* The textbook form (-b +/- sqrt(delta)) / 2a is fine on paper but
           loses precision on a machine: when b*b >> 4ac, sqrt(delta) is very
           close to |b|, so one of the two numerators subtracts near-equal
           numbers and most significant digits cancel out.
           Computing the root whose numerator ADDS (never cancels), then
           deducing the other from the product rule x1*x2 = c/a, keeps both
           accurate. q is never 0 here because delta > 0. */
        double sqrtDelta = Math.sqrt(delta);
        double q = -0.5 * (b + (b >= 0 ? sqrtDelta : -sqrtDelta));
        double x1 = q / a;
        double x2 = c / q;

        return "delta > 0. Two roots: x1 = " + fmt(Math.min(x1, x2))
               + ", x2 = " + fmt(Math.max(x1, x2));
    }

    /* |value| is negligible compared to scale. The max(1, scale) keeps the
       test meaningful when scale itself is tiny or zero. */
    private static boolean isNegligible(double value, double scale)
    {
        return Math.abs(value) <= TOL * Math.max(1.0, scale);
    }
}
