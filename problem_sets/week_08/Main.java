import simulator.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // ===== SCENE 01: DROP =====
        String[] drop = {
                "#######",
                "#  .  #",
                "#  .  #",
                "#  .  #",
                "#     #",
                "#     #",
                "#######" };

        // build a world from the above scene
        World w1 = new World(drop);
        System.out.print("\033[2J"); // clear the screen once before the first frame
        for (int t = 0; t < 10; t++) {
            w1.cliRender();
            Thread.sleep(500);
            w1.step();
        }
        w1.cliRender();
        System.out.println();

        // ===== SCENE 02: HOURGLASS =====
        String[] hourglass = {
                "###########",
                "#.........#",
                "##.......##",
                "###.....###",
                "####...####",
                "##### #####",
                "####   ####",
                "###     ###",
                "##       ##",
                "#         #",
                "###########"
        };

        // build a world from the above scene
        World w2 = new World(hourglass);
        System.out.print("\033[2J"); // clear the screen once before the first frame
        for (int t = 0; t < 30; t++) {
            w2.cliRender();
            Thread.sleep(500);
            w2.step();
        }
        w2.cliRender();
        System.out.println();
    }

    public static boolean conserves(World w, String name, int n) {
        // init count for w
        int sand1 = w.count("sand");

        // run word for n ticks
        w.run(n);

        // new sand count (not supposed to evolve without fire)
        int sand2 = w.count("sand");

        return(sand1 == sand2);
    }
}

