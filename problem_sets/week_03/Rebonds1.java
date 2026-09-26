
import java.util.Scanner;


public class Rebonds1 {

    public final double g = 9.81;
    public void main(String[] args)
    {
        // scanner
        Scanner in = new Scanner(System.in);

        // input
        double h0=-1.0, eps=0; 
        int n = 0;
        System.out.print("Enter initial height (h_0): ");
        h0 = in.nextDouble();
        System.out.print("Enter rebound coeff (eps): ");
        eps = in.nextDouble();
        System.out.print("Enter number of rebounds (n): ");
        n = in.nextInt();

        // iterations
        double h_final = make_rebounds(n, h0, eps);

        // out
        System.out.println("[OUTPUT]: h(n) = " + h_final);

        in.close();

    }

    private double v(double height)
    {
        return Math.sqrt(2 * g * height);
    }

    private double h(double v)
    {
        return (v*v)/(2*g);
    }

    private double make_rebounds(int n, double h0, double eps)
    {
        double h_n = h0;
        double v_n = v(h_n);

        for(int i = 1; i <= n; ++i)
        {
            v_n = eps * v_n; // speed just after n-th rebound
            h_n = h(v_n); // height of n-th rebound
            v_n = v(h_n);

        }

        return h_n;
    }
    
}
