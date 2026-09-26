import java.util.Scanner;

public class Rebonds2
{
    public final double g = 9.81;
    public void main(String[] args)
    {
        // scanner
        Scanner in = new Scanner(System.in);

        // input
        double h0=-1.0, eps=0; 
        double h_final = 0;
        System.out.print("Enter initial height (h_0): ");
        h0 = in.nextDouble();
        System.out.print("Enter rebound coeff (eps): ");
        eps = in.nextDouble();
        System.out.print("Enter final height: ");
        h_final = in.nextDouble();

        // find n
        int n_final = find_n(h0, eps, h_final);

        // output
        System.out.println("[OUTPUT]: h < " + h_final + " -> n >= " + n_final);

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

    private int find_n(double h0, double eps, double h_final)
    {
        int n = 0;
        double h_n = h0;
        double v_n = v(h_n);
        do
        {
            n++; // new rebound
            v_n = eps * v_n; // speed just after rebound
            h_n = h(v_n); // height reached after rebound
            v_n = v(h_n); // speed just before rebound

        }while(h_n > h_final);

        return n;
    }
}
