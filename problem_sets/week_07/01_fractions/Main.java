/*
Tests on the Fraction object.
Run with assertions enabled:
    javac *.java && java -ea Main
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main
{
    private static final String ZERO_DEN_MSG = "Error: zero denominator, fraction set to 0";

    public static void main(String[] args)
    {
        if (!assertionsEnabled())
        {
            System.out.println("Assertions are disabled: run with `java -ea Main`.");
            return;
        }

        // ___ 1. constructors and normalisation ___
        assert testReducePositive()            : "testReducePositive() failed.";
        assert testAlreadyReduced()            : "testAlreadyReduced() failed.";
        assert testNegativeDenominator()       : "testNegativeDenominator() failed.";
        assert testNegativeNumerator()         : "testNegativeNumerator() failed.";
        assert testBothNegative()              : "testBothNegative() failed.";
        assert testZeroNumerator()             : "testZeroNumerator() failed.";
        assert testZeroNumeratorNegativeDen()  : "testZeroNumeratorNegativeDen() failed.";
        assert testReducesToInteger()          : "testReducesToInteger() failed.";
        assert testDenominatorOne()            : "testDenominatorOne() failed.";
        assert testNegativeOverNegativeOne()   : "testNegativeOverNegativeOne() failed.";
        assert testNumeratorLargerThanDen()    : "testNumeratorLargerThanDen() failed.";
        assert testLargeGcd()                  : "testLargeGcd() failed.";
        assert testLargeValues()               : "testLargeValues() failed.";
        assert testZeroDenominatorValue()      : "testZeroDenominatorValue() failed.";
        assert testZeroDenominatorMessage()    : "testZeroDenominatorMessage() failed.";
        assert testValidConstructorSilent()    : "testValidConstructorSilent() failed.";
        assert testIntegerConstructor()        : "testIntegerConstructor() failed.";
        assert testIntegerConstructorNegative(): "testIntegerConstructorNegative() failed.";
        assert testIntegerConstructorZero()    : "testIntegerConstructorZero() failed.";
        assert testDefaultConstructor()        : "testDefaultConstructor() failed.";
        assert testCopyConstructorValue()      : "testCopyConstructorValue() failed.";
        assert testCopyConstructorNewObject()  : "testCopyConstructorNewObject() failed.";

        // ___ 2. toString ___
        assert testToStringFraction()          : "testToStringFraction() failed.";
        assert testToStringNegative()          : "testToStringNegative() failed.";
        assert testToStringInteger()           : "testToStringInteger() failed.";
        assert testToStringNegativeInteger()   : "testToStringNegativeInteger() failed.";
        assert testToStringZero()              : "testToStringZero() failed.";
        assert testToStringNormalised()        : "testToStringNormalised() failed.";

        // ___ 3. equals ___
        assert testEqualsSameForm()            : "testEqualsSameForm() failed.";
        assert testEqualsDifferentForm()       : "testEqualsDifferentForm() failed.";
        assert testEqualsSignForms()           : "testEqualsSignForms() failed.";
        assert testEqualsSelf()                : "testEqualsSelf() failed.";
        assert testEqualsSymmetric()           : "testEqualsSymmetric() failed.";
        assert testNotEqualsDifferentValue()   : "testNotEqualsDifferentValue() failed.";
        assert testNotEqualsOppositeSign()     : "testNotEqualsOppositeSign() failed.";
        assert testNotEqualsSameNumerator()    : "testNotEqualsSameNumerator() failed.";
        assert testEqualsNull()                : "testEqualsNull() failed.";
        assert testEqualsZeroForms()           : "testEqualsZeroForms() failed.";

        // ___ 4. add ___
        assert testAddSimple()                 : "testAddSimple() failed.";
        assert testAddNeedsReduction()         : "testAddNeedsReduction() failed.";
        assert testAddNegative()               : "testAddNegative() failed.";
        assert testAddOpposites()              : "testAddOpposites() failed.";
        assert testAddZero()                   : "testAddZero() failed.";
        assert testAddIntegers()               : "testAddIntegers() failed.";
        assert testAddCommutative()            : "testAddCommutative() failed.";
        assert testAddExactDecimal()           : "testAddExactDecimal() failed.";

        // ___ 5. subtract ___
        assert testSubtractSimple()            : "testSubtractSimple() failed.";
        assert testSubtractToNegative()        : "testSubtractToNegative() failed.";
        assert testSubtractSelf()              : "testSubtractSelf() failed.";
        assert testSubtractNegative()          : "testSubtractNegative() failed.";
        assert testSubtractZero()              : "testSubtractZero() failed.";
        assert testSubtractFromZero()          : "testSubtractFromZero() failed.";

        // ___ 6. multiply ___
        assert testMultiplySimple()            : "testMultiplySimple() failed.";
        assert testMultiplyToOne()             : "testMultiplyToOne() failed.";
        assert testMultiplyByZero()            : "testMultiplyByZero() failed.";
        assert testMultiplyNegatives()         : "testMultiplyNegatives() failed.";
        assert testMultiplyMixedSigns()        : "testMultiplyMixedSigns() failed.";
        assert testMultiplyByOne()             : "testMultiplyByOne() failed.";
        assert testMultiplyIntegers()          : "testMultiplyIntegers() failed.";

        // ___ 7. divide ___
        assert testDivideSimple()              : "testDivideSimple() failed.";
        assert testDivideToInteger()           : "testDivideToInteger() failed.";
        assert testDivideByNegative()          : "testDivideByNegative() failed.";
        assert testDivideNegatives()           : "testDivideNegatives() failed.";
        assert testDivideZeroByNonZero()       : "testDivideZeroByNonZero() failed.";
        assert testDivideBySelf()              : "testDivideBySelf() failed.";
        assert testDivideByZeroReturnsNull()   : "testDivideByZeroReturnsNull() failed.";
        assert testDivideByZeroFromCalc()      : "testDivideByZeroFromCalc() failed.";
        assert testDivideZeroByZero()          : "testDivideZeroByZero() failed.";

        // ___ 8. reciprocal ___
        assert testReciprocalSimple()          : "testReciprocalSimple() failed.";
        assert testReciprocalNegative()        : "testReciprocalNegative() failed.";
        assert testReciprocalInteger()         : "testReciprocalInteger() failed.";
        assert testReciprocalUnitFraction()    : "testReciprocalUnitFraction() failed.";
        assert testReciprocalTwice()           : "testReciprocalTwice() failed.";
        assert testReciprocalOfZero()          : "testReciprocalOfZero() failed.";

        // ___ 9. isLessThan ___
        assert testLessThanPositive()          : "testLessThanPositive() failed.";
        assert testLessThanNotReversed()       : "testLessThanNotReversed() failed.";
        assert testLessThanNegativeVsPositive(): "testLessThanNegativeVsPositive() failed.";
        assert testLessThanBothNegative()      : "testLessThanBothNegative() failed.";
        assert testLessThanEqualIsFalse()      : "testLessThanEqualIsFalse() failed.";
        assert testLessThanSameValueDiffForm() : "testLessThanSameValueDiffForm() failed.";
        assert testLessThanZero()              : "testLessThanZero() failed.";
        assert testLessThanCloseValues()       : "testLessThanCloseValues() failed.";
        assert testLessThanIntegers()          : "testLessThanIntegers() failed.";

        // ___ 10. toDouble ___
        assert testToDoubleSimple()            : "testToDoubleSimple() failed.";
        assert testToDoubleNegative()          : "testToDoubleNegative() failed.";
        assert testToDoubleInteger()           : "testToDoubleInteger() failed.";
        assert testToDoubleZero()              : "testToDoubleZero() failed.";
        assert testToDoubleThird()             : "testToDoubleThird() failed.";

        // ___ 11. immutability and invariants ___
        assert testAddDoesNotModify()          : "testAddDoesNotModify() failed.";
        assert testSubtractDoesNotModify()     : "testSubtractDoesNotModify() failed.";
        assert testMultiplyDoesNotModify()     : "testMultiplyDoesNotModify() failed.";
        assert testDivideDoesNotModify()       : "testDivideDoesNotModify() failed.";
        assert testReciprocalDoesNotModify()   : "testReciprocalDoesNotModify() failed.";
        assert testOperationsReturnNewObject() : "testOperationsReturnNewObject() failed.";
        assert testInvariantOnResults()        : "testInvariantOnResults() failed.";
        assert testHarmonicSum()               : "testHarmonicSum() failed.";

        System.out.println("All tests passed.");

        // ___ EXERCISE 1.2 ___
        // ___ 12. FractionLab ___
        for(int i = 1; i <= 10; ++i) {
            FractionLab h = new FractionLab(i);
            System.out.println(i + ": " + h);
        }

        // ___ 13. test FractionLab with bigger n ___
        FractionLab h20 =  new FractionLab(20);
        System.out.println(h20);

        // ___ EXERCISES 1.3 ___

    }

    // ___ HELPERS ___

    // true if assertions are enabled (-ea)
    private static boolean assertionsEnabled()
    {
        boolean enabled = false;
        assert enabled = true; // side effect only runs when -ea is on
        return enabled;
    }

    // true if f is not null and stores exactly n / d
    private static boolean is(Fraction f, long n, long d)
    {
        return f != null && f.getNumerator() == n && f.getDenominator() == d;
    }

    // gcd on non-negative values, used to check the class invariant
    private static long gcd(long a, long b)
    {
        while (b != 0)
        {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // invariant: denominator > 0 and gcd(|n|, d) == 1
    private static boolean invariantHolds(Fraction f)
    {
        if (f == null) return false;
        long n = f.getNumerator();
        long d = f.getDenominator();
        return d > 0 && gcd(Math.abs(n), d) == 1;
    }

    // run the constructor n / d and return what it printed
    private static String outputOf(long n, long d)
    {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        new Fraction(n, d);
        System.out.flush();
        System.setOut(original);
        return buffer.toString();
    }

    // ___ 1. CONSTRUCTORS ___

    private static boolean testReducePositive()
    {
        return is(new Fraction(2, 4), 1, 2);
    }

    private static boolean testAlreadyReduced()
    {
        return is(new Fraction(3, 7), 3, 7);
    }

    private static boolean testNegativeDenominator()
    {
        return is(new Fraction(6, -8), -3, 4);
    }

    private static boolean testNegativeNumerator()
    {
        return is(new Fraction(-4, 6), -2, 3);
    }

    private static boolean testBothNegative()
    {
        return is(new Fraction(-3, -6), 1, 2);
    }

    private static boolean testZeroNumerator()
    {
        return is(new Fraction(0, 5), 0, 1);
    }

    private static boolean testZeroNumeratorNegativeDen()
    {
        return is(new Fraction(0, -7), 0, 1);
    }

    private static boolean testReducesToInteger()
    {
        return is(new Fraction(10, 5), 2, 1);
    }

    private static boolean testDenominatorOne()
    {
        return is(new Fraction(7, 1), 7, 1);
    }

    private static boolean testNegativeOverNegativeOne()
    {
        return is(new Fraction(-7, -1), 7, 1) && is(new Fraction(7, -1), -7, 1);
    }

    private static boolean testNumeratorLargerThanDen()
    {
        return is(new Fraction(9, 6), 3, 2) && is(new Fraction(-9, 6), -3, 2);
    }

    private static boolean testLargeGcd()
    {
        // gcd(123456, 7890) = 6
        return is(new Fraction(123456, 7890), 20576, 1315);
    }

    private static boolean testLargeValues()
    {
        long big = 1_000_000_007L; // prime
        return is(new Fraction(2 * big, 4), big, 2) && is(new Fraction(big, 3 * big), 1, 3);
    }

    private static boolean testZeroDenominatorValue()
    {
        PrintStream original = System.out;
        System.setOut(new PrintStream(new ByteArrayOutputStream())); // silence message
        Fraction f = new Fraction(3, 0);
        System.setOut(original);
        return is(f, 0, 1);
    }

    private static boolean testZeroDenominatorMessage()
    {
        return outputOf(3, 0).equals(ZERO_DEN_MSG + System.lineSeparator());
    }

    private static boolean testValidConstructorSilent()
    {
        return outputOf(1, 2).isEmpty() && outputOf(0, 3).isEmpty() && outputOf(4, -2).isEmpty();
    }

    private static boolean testIntegerConstructor()
    {
        return is(new Fraction(5), 5, 1);
    }

    private static boolean testIntegerConstructorNegative()
    {
        return is(new Fraction(-5), -5, 1);
    }

    private static boolean testIntegerConstructorZero()
    {
        return is(new Fraction(0), 0, 1);
    }

    private static boolean testDefaultConstructor()
    {
        return is(new Fraction(), 0, 1);
    }

    private static boolean testCopyConstructorValue()
    {
        Fraction a = new Fraction(6, -8);
        Fraction c = new Fraction(a);
        return is(c, -3, 4) && c.equals(a);
    }

    private static boolean testCopyConstructorNewObject()
    {
        Fraction a = new Fraction(1, 3);
        return new Fraction(a) != a;
    }

    // ___ 2. TOSTRING ___

    private static boolean testToStringFraction()
    {
        return new Fraction(1, 4).toString().equals("1/4");
    }

    private static boolean testToStringNegative()
    {
        return new Fraction(6, -8).toString().equals("-3/4");
    }

    private static boolean testToStringInteger()
    {
        return new Fraction(10, 5).toString().equals("2");
    }

    private static boolean testToStringNegativeInteger()
    {
        return new Fraction(-5).toString().equals("-5");
    }

    private static boolean testToStringZero()
    {
        return new Fraction().toString().equals("0") && new Fraction(0, -7).toString().equals("0");
    }

    private static boolean testToStringNormalised()
    {
        return new Fraction(-12, -18).toString().equals("2/3");
    }

    // ___ 3. EQUALS ___

    private static boolean testEqualsSameForm()
    {
        return new Fraction(1, 2).equals(new Fraction(1, 2));
    }

    private static boolean testEqualsDifferentForm()
    {
        return new Fraction(2, 4).equals(new Fraction(-3, -6));
    }

    private static boolean testEqualsSignForms()
    {
        return new Fraction(-1, 2).equals(new Fraction(1, -2));
    }

    private static boolean testEqualsSelf()
    {
        Fraction a = new Fraction(5, 7);
        return a.equals(a);
    }

    private static boolean testEqualsSymmetric()
    {
        Fraction a = new Fraction(3, 9);
        Fraction b = new Fraction(1, 3);
        return a.equals(b) && b.equals(a);
    }

    private static boolean testNotEqualsDifferentValue()
    {
        return !new Fraction(1, 2).equals(new Fraction(1, 3));
    }

    private static boolean testNotEqualsOppositeSign()
    {
        return !new Fraction(1, 2).equals(new Fraction(-1, 2));
    }

    private static boolean testNotEqualsSameNumerator()
    {
        return !new Fraction(2, 3).equals(new Fraction(2, 5));
    }

    private static boolean testEqualsNull()
    {
        return !new Fraction(6, -8).equals(null);
    }

    private static boolean testEqualsZeroForms()
    {
        return new Fraction(0, 5).equals(new Fraction(0, -3)) && new Fraction().equals(new Fraction(0));
    }

    // ___ 4. ADD ___

    private static boolean testAddSimple()
    {
        return is(new Fraction(1, 2).add(new Fraction(1, 3)), 5, 6);
    }

    private static boolean testAddNeedsReduction()
    {
        return is(new Fraction(1, 6).add(new Fraction(1, 3)), 1, 2);
    }

    private static boolean testAddNegative()
    {
        return is(new Fraction(6, -8).add(new Fraction(1, 4)), -1, 2);
    }

    private static boolean testAddOpposites()
    {
        return is(new Fraction(1, 2).add(new Fraction(-1, 2)), 0, 1);
    }

    private static boolean testAddZero()
    {
        Fraction a = new Fraction(-2, 7);
        return is(a.add(new Fraction()), -2, 7) && is(new Fraction().add(a), -2, 7);
    }

    private static boolean testAddIntegers()
    {
        return is(new Fraction(3).add(new Fraction(-5)), -2, 1);
    }

    private static boolean testAddCommutative()
    {
        Fraction a = new Fraction(2, 9);
        Fraction b = new Fraction(-5, 6);
        return a.add(b).equals(b.add(a));
    }

    private static boolean testAddExactDecimal()
    {
        // 0.1 + 0.2 == 0.3 exactly
        Fraction r = new Fraction(1, 10).add(new Fraction(2, 10));
        return r.equals(new Fraction(3, 10));
    }

    // ___ 5. SUBTRACT ___

    private static boolean testSubtractSimple()
    {
        return is(new Fraction(1, 2).subtract(new Fraction(1, 3)), 1, 6);
    }

    private static boolean testSubtractToNegative()
    {
        return is(new Fraction(1, 3).subtract(new Fraction(1, 2)), -1, 6);
    }

    private static boolean testSubtractSelf()
    {
        Fraction a = new Fraction(7, 11);
        return is(a.subtract(a), 0, 1);
    }

    private static boolean testSubtractNegative()
    {
        return is(new Fraction(6, -8).subtract(new Fraction(1, 4)), -1, 1)
            && is(new Fraction(1, 4).subtract(new Fraction(-1, 4)), 1, 2);
    }

    private static boolean testSubtractZero()
    {
        return is(new Fraction(3, 5).subtract(new Fraction()), 3, 5);
    }

    private static boolean testSubtractFromZero()
    {
        return is(new Fraction().subtract(new Fraction(3, 5)), -3, 5);
    }

    // ___ 6. MULTIPLY ___

    private static boolean testMultiplySimple()
    {
        return is(new Fraction(6, -8).multiply(new Fraction(1, 4)), -3, 16);
    }

    private static boolean testMultiplyToOne()
    {
        return is(new Fraction(2, 3).multiply(new Fraction(3, 2)), 1, 1);
    }

    private static boolean testMultiplyByZero()
    {
        return is(new Fraction(5, 9).multiply(new Fraction()), 0, 1)
            && is(new Fraction().multiply(new Fraction(-5, 9)), 0, 1);
    }

    private static boolean testMultiplyNegatives()
    {
        return is(new Fraction(-2, 3).multiply(new Fraction(-3, 4)), 1, 2);
    }

    private static boolean testMultiplyMixedSigns()
    {
        return is(new Fraction(2, -3).multiply(new Fraction(9, 4)), -3, 2);
    }

    private static boolean testMultiplyByOne()
    {
        return is(new Fraction(4, 9).multiply(new Fraction(1)), 4, 9);
    }

    private static boolean testMultiplyIntegers()
    {
        return is(new Fraction(-3).multiply(new Fraction(4)), -12, 1);
    }

    // ___ 7. DIVIDE ___

    private static boolean testDivideSimple()
    {
        return is(new Fraction(1, 2).divide(new Fraction(3, 4)), 2, 3);
    }

    private static boolean testDivideToInteger()
    {
        return is(new Fraction(6, -8).divide(new Fraction(1, 4)), -3, 1);
    }

    private static boolean testDivideByNegative()
    {
        return is(new Fraction(1, 2).divide(new Fraction(-1, 4)), -2, 1);
    }

    private static boolean testDivideNegatives()
    {
        return is(new Fraction(-1, 2).divide(new Fraction(-1, 3)), 3, 2);
    }

    private static boolean testDivideZeroByNonZero()
    {
        return is(new Fraction().divide(new Fraction(5, 7)), 0, 1);
    }

    private static boolean testDivideBySelf()
    {
        Fraction a = new Fraction(-13, 17);
        return is(a.divide(a), 1, 1);
    }

    private static boolean testDivideByZeroReturnsNull()
    {
        return new Fraction(6, -8).divide(new Fraction()) == null;
    }

    private static boolean testDivideByZeroFromCalc()
    {
        Fraction zero = new Fraction(1, 3).subtract(new Fraction(2, 6));
        return new Fraction(4, 5).divide(zero) == null;
    }

    private static boolean testDivideZeroByZero()
    {
        return new Fraction().divide(new Fraction()) == null;
    }

    // ___ 8. RECIPROCAL ___

    private static boolean testReciprocalSimple()
    {
        return is(new Fraction(2, 3).reciprocal(), 3, 2);
    }

    private static boolean testReciprocalNegative()
    {
        return is(new Fraction(-2, 3).reciprocal(), -3, 2);
    }

    private static boolean testReciprocalInteger()
    {
        return is(new Fraction(5).reciprocal(), 1, 5) && is(new Fraction(-5).reciprocal(), -1, 5);
    }

    private static boolean testReciprocalUnitFraction()
    {
        return is(new Fraction(1, 7).reciprocal(), 7, 1);
    }

    private static boolean testReciprocalTwice()
    {
        Fraction a = new Fraction(-8, 3);
        Fraction r = a.reciprocal();
        return r != null && r.reciprocal() != null && r.reciprocal().equals(a);
    }

    private static boolean testReciprocalOfZero()
    {
        return new Fraction().reciprocal() == null;
    }

    // ___ 9. ISLESSTHAN ___

    private static boolean testLessThanPositive()
    {
        return new Fraction(1, 3).isLessThan(new Fraction(1, 2));
    }

    private static boolean testLessThanNotReversed()
    {
        return !new Fraction(1, 2).isLessThan(new Fraction(1, 3));
    }

    private static boolean testLessThanNegativeVsPositive()
    {
        Fraction a = new Fraction(6, -8);
        Fraction b = new Fraction(1, 4);
        return a.isLessThan(b) && !b.isLessThan(a);
    }

    private static boolean testLessThanBothNegative()
    {
        Fraction a = new Fraction(-1, 2);
        Fraction b = new Fraction(1, -3);
        return a.isLessThan(b) && !b.isLessThan(a);
    }

    private static boolean testLessThanEqualIsFalse()
    {
        Fraction a = new Fraction(2, 5);
        return !a.isLessThan(a) && !a.isLessThan(new Fraction(2, 5));
    }

    private static boolean testLessThanSameValueDiffForm()
    {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(-4, -8);
        return !a.isLessThan(b) && !b.isLessThan(a);
    }

    private static boolean testLessThanZero()
    {
        Fraction zero = new Fraction();
        return new Fraction(-1, 100).isLessThan(zero)
            && zero.isLessThan(new Fraction(1, 100))
            && !zero.isLessThan(zero);
    }

    private static boolean testLessThanCloseValues()
    {
        // 999999/1000000 < 1000000/1000001
        Fraction a = new Fraction(999_999, 1_000_000);
        Fraction b = new Fraction(1_000_000, 1_000_001);
        return a.isLessThan(b) && !b.isLessThan(a);
    }

    private static boolean testLessThanIntegers()
    {
        return new Fraction(-3).isLessThan(new Fraction(2)) && !new Fraction(2).isLessThan(new Fraction(-3));
    }

    // ___ 10. TODOUBLE ___

    private static boolean testToDoubleSimple()
    {
        return new Fraction(1, 4).toDouble() == 0.25;
    }

    private static boolean testToDoubleNegative()
    {
        return new Fraction(6, -8).toDouble() == -0.75;
    }

    private static boolean testToDoubleInteger()
    {
        return new Fraction(10, 5).toDouble() == 2.0;
    }

    private static boolean testToDoubleZero()
    {
        return new Fraction(0, -7).toDouble() == 0.0;
    }

    private static boolean testToDoubleThird()
    {
        return Math.abs(new Fraction(1, 3).toDouble() - 1.0 / 3.0) < 1e-15;
    }

    // ___ 11. IMMUTABILITY AND INVARIANTS ___

    private static boolean testAddDoesNotModify()
    {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(1, 3);
        a.add(b);
        return is(a, 1, 2) && is(b, 1, 3);
    }

    private static boolean testSubtractDoesNotModify()
    {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(1, 3);
        a.subtract(b);
        return is(a, 1, 2) && is(b, 1, 3);
    }

    private static boolean testMultiplyDoesNotModify()
    {
        Fraction a = new Fraction(-2, 5);
        Fraction b = new Fraction(3, 7);
        a.multiply(b);
        return is(a, -2, 5) && is(b, 3, 7);
    }

    private static boolean testDivideDoesNotModify()
    {
        Fraction a = new Fraction(-2, 5);
        Fraction b = new Fraction(3, 7);
        a.divide(b);
        return is(a, -2, 5) && is(b, 3, 7);
    }

    private static boolean testReciprocalDoesNotModify()
    {
        Fraction a = new Fraction(-2, 5);
        a.reciprocal();
        return is(a, -2, 5);
    }

    private static boolean testOperationsReturnNewObject()
    {
        Fraction a = new Fraction(1, 2);
        Fraction zero = new Fraction();
        Fraction one = new Fraction(1);
        return a.add(zero) != a
            && a.subtract(zero) != a
            && a.multiply(one) != a
            && a.divide(one) != a;
    }

    private static boolean testInvariantOnResults()
    {
        Fraction a = new Fraction(-14, 21);
        Fraction b = new Fraction(10, -4);
        return invariantHolds(a)
            && invariantHolds(b)
            && invariantHolds(a.add(b))
            && invariantHolds(a.subtract(b))
            && invariantHolds(a.multiply(b))
            && invariantHolds(a.divide(b))
            && invariantHolds(b.divide(a))
            && invariantHolds(a.reciprocal())
            && invariantHolds(b.reciprocal())
            && invariantHolds(new Fraction(a));
    }

    private static boolean testHarmonicSum()
    {
        // 1 + 1/2 + 1/3 + 1/4 = 25/12
        Fraction h = new Fraction();
        for (long k = 1; k <= 4; k++)
        {
            h = h.add(new Fraction(1, k));
        }
        return is(h, 25, 12);
    }
}
