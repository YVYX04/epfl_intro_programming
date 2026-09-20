public class Types
{
    public static void main(String[] args)
    {
        int n1 = 2; // n1 = 2
        double r1 = 2.7; // r1 = 2.70

        int n2 = 2.7; // x
        double r2 = 5; // r2 = 5.0

        int n3 = (int) 5.6; // n3 = 5
        double r3 = 5.6; // r3 = 5.6

        int n4 = 9; // n4 = 9
        double r4 = (double) n4; // r4 = 9.0
        double r5 = (int) r4; // r5 = 9.0

        int n5 = 19 / 4; // n5 = 4
        int n6 = n5 / r5; // x
        double r6 = 5.0; // r6 = 5.0
        int n7 = (int) (n5 / r5); // n7 = 0
        double r7 = 19.0 / r6; // r7 = 3.80

        double r8 = 15.0 / n3; // r8 = 3.0
        double r9 = 19 / 4; // r9 = 4.0
        double r10 = (double) (19 / 4); // r10 = 4.0
        double r11 = (double) 19 / (double) 4; // r11 = 4.75
    }
    
}
