import java.util.Scanner;

public class IMC
{
    public static void main(String[] args)
    {

        // UI
        System.out.println("--- BMI Calculator ---");

        // init a new Scanner object
        Scanner keyb = new Scanner(System.in);

        // ask the user the relevant input
        double height_m, weight_kg;
        System.out.print("> Please, enter your height (m): ");
        height_m = keyb.nextDouble();
        System.out.print("> Please, enter your weight (kg): ");
        weight_kg = keyb.nextDouble();

        // print result
        double ans = weight_kg / (height_m * height_m);
        System.out.printf("Your BMI is: %.2f\n", ans);

        keyb.close();
        return;

    }
    
}

/*
+------+
| DEMO |
+------+

--- BMI Calculator ---
> Please, enter your height (m): 1.85
> Please, enter your weight (kg): 90
Your BMI is: 26.30
*/