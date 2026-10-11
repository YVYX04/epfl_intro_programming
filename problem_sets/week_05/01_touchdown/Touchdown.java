/*
                        +----------------+
                        | Touchdown.java |
                        +----------------+

This program represents a possible solution to mission one exposed in 
problem_sets/week_05/five_missions.pdf


TO BE IMPLEMENTED:
- search_optimal_policy() -> print what is the best policy according to the spec
- print a comparison between player policy and optimal policy

*/

import java.util.Scanner;

public class Touchdown
{
    static Scanner in = new Scanner(System.in);

    // initial parameters and allowed range
    static final int MIN_F = 0, MAX_F = 80;
    static final int MIN_THRUST = 0, MAX_THRUST = 4;
    static final int MIN_TURN = 0, MAX_TURN = 30;
    static final double MIN_H = 0, MAX_H = 100;
    static final double MIN_V = -10, MAX_V = 0;
    static final double GRAVITY = 1.6;

    public static void main(String[] args)
    {
        // 1. banner
        print_banner();

        // 2. rules
        print_rules();

        // game loop
        boolean game = true;

        while(game)
        {

            // 3. initial set-up
            int f = 24, turn = 1; // start at turn t = 1.
            double h = 60.0, v = -4.0;
            boolean pulsing = true;
            double g;

            // 4. update loop
            do
            {
                // print current states
                print_state(turn, h, v, f);

                // choose thrust u 
                int u = select_thrust(f);
                
                // handle wrong input
                if(u == -1)
                {
                    System.out.println();
                    System.out.println("● The allowed values for u are: {0, 1, 2, 3, 4}.");
                    System.out.println("● The game will resume at turn " + turn + ".");
                    continue;
                }

                if(u == -2)
                {
                    System.out.println();
                    System.out.println("● You cannot consume more fuel than you have!");
                    System.out.println("● The game will resume at turn " + turn + ".");
                    continue;
                }

                // update values
                f = f - u;
                v = v - gravity(pulsing, turn) + u;
                h = h + v;
                ++turn;

                // space between turn
                System.out.println();


            } while(h > 0 && turn <= 30);

            if(turn > 30 && h > 0)
            {
                System.out.println("⚠ timed out - too many seconds airborne  ⚠");
                game_over();
            } else if(v > 0 || v < -3)
            {
                System.out.println("⚠ crashed - your speed did not allow for a safe landing!  ⚠");
                game_over();
            } else win();

            // replay
            System.out.println();
            System.out.println("❯ Replay [R], quit [other key].");

            in.nextLine(); // Only needed after nextInt(), nextDouble(), etc.
            String repeat = in.nextLine();

            if (!repeat.equals("R"))
            {
                game = false;
            } else {
                System.out.println();
                System.out.println("╭───────────────────╮");
                System.out.println("│ New attempt       │");
                System.out.println("╰───────────────────╯");
            }
        }

        return;
    }

    // ---------
    // FUNCTIONS
    // ---------

    // A. Print
    // banner(): print a banner for the game welcome ui
    public static void print_banner()
    {
        System.out.println();
        System.out.println("         /\\");
        System.out.println("        /  \\");
        System.out.println("        |()|");
        System.out.println("        |  |");
        System.out.println("       /|  |\\");
        System.out.println("      /_|__|_\\");
        System.out.println("        /::\\");
        System.out.println("         \\/");
        System.out.println();
        System.out.println("   T O U C H D O W N");
        System.out.println("   ----------------");
        System.out.println();
    }

    // print_rules(): explain the controls, the physics and how a flight ends
    public static void print_rules()
    {
        System.out.println("╭─ ✻ Rules ─────────────────────────");
        System.out.println("│ Your lander is falling towards the Moon.");
        System.out.println("│ Each turn lasts one second: choose a thrust u");
        System.out.println("│ between " + MIN_THRUST + " and " + MAX_THRUST + ". Each unit of thrust burns one");
        System.out.println("│ unit of fuel and pushes you up by 1 m/s.");
        System.out.println("│");
        System.out.println("│ Every turn, in this order:");
        System.out.println("│   fuel     <- fuel - u");
        System.out.println("│   velocity <- velocity - gravity + u");
        System.out.println("│   altitude <- altitude + velocity");
        System.out.println("│ Positive velocity means going up.");
        System.out.println("│");
        System.out.println("│ Gravity is " + GRAVITY + " m/s² (calm) or gently pulsing");
        System.out.println("│ between 1.4 and 1.8 m/s² (pulsing).");
        System.out.println("│");
        System.out.println("│ Once altitude reaches 0 or below:");
        System.out.println("│   ★ safe landing if velocity is between -3.0 and 0");
        System.out.println("│   ☠ crash otherwise");
        System.out.println("│ Still airborne after turn " + MAX_TURN + "? You time out.");
        System.out.println("│");
        System.out.println("│ You cannot burn more fuel than you have, but");
        System.out.println("│ u = 0 is always allowed. An invalid thrust costs");
        System.out.println("│ neither fuel nor a turn.");
        System.out.println("╰───────────────────────────────────");
        System.out.println();
    }

    // print_state(): print the velocity, altitude, remaining fuel
    public static void print_state(int t, double h, double v, int f)
    {
        System.out.println("╭─ ✻ Turn " + t + " ────────────────────────");
        System.out.printf("│ velocity: %.2f [m/s].\n", v);
        System.out.printf("│ altitude: %.2f [m].\n", h);

        // compute icon
        String icon;
        double f_pct = (double) f / MAX_F;
        if(f_pct == 0) icon = "○○○○○";
        else if (f_pct <= 0.2) icon = "●○○○○";
        else if (f_pct > 0.2 && f_pct <= 0.4) icon = "●●○○○";
        else if (f_pct > 0.4 && f_pct <= 0.6) icon = "●●●○○";
        else if (f_pct > 0.6 && f_pct <= 0.8) icon = "●●●●○";
        else icon = "●●●●●";
        
        // print fuel
        System.out.println("│ fuel: " + icon + " (" + f  +"/" + MAX_F + ") [unit].");
        System.out.println("╰───────────────────────────────────");
    }

    // game_over()
    public static void game_over()
    {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       ☠  GAME  OVER  ☠       ║");
        System.out.println("╚══════════════════════════════╝");
    }

    // win()
    public static void win()
    {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║      ★ SAFE LANDING! ★       ║");
        System.out.println("╚══════════════════════════════╝");
    }

    // B. GAME MECHANICS
    // ------------------
    // compute_gravity()
    public static double gravity(boolean pulsing, int t)
    {
        if(pulsing) return GRAVITY + 0.2 * Math.sin(t * Math.PI / 6.0);
        else return GRAVITY;
    }

    // C. INPUTS
    // ----------
    // select_thrust()
    public static int select_thrust(int f)
    {
        /*
        This function prompts the user to select a thrust unit u \in {0, 1, 2, 3, 4}
        and return the selected fuel unit.
        */
        System.out.print("❯ Please select a thrust unit (0 - 4): ");

        int u = in.nextInt();
        if(u < MIN_THRUST || u > MAX_THRUST) return -1; // error code
        if(u > f) return -2;
        return u;
    }
}
