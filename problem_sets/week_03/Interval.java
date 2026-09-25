import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        // input
        Scanner in = new Scanner(System.in);

        // check interval appartenance
        boolean run = true;
        while(run) {
            boolean i = false;
            System.out.print("Enter a double: x = ");
            double x = in.nextDouble();
            if(x >= -10 && x <= -2) i = true;
            if(i) {
                System.out.println("x in interval I.");
                continue;
            }

            if(x > 0 && x <= 1) i = true;
            if(i) {
                System.out.println("x in interval I.");
                continue;
            }

            if(x >= 2 && x < 3) i = true;
            if(i) {
                System.out.println("x in interval I.");
                continue;
            }

            System.out.println("x not in I!");

            // start again?
            System.out.print("Repeat? [y/n]: ");
            String again = in.next().toLowerCase();
            if(again.equals("n")) run = false;
        }

    }
    
}
