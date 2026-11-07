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
            Thread.sleep(300);
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
            Thread.sleep(125);
            w2.step();
        }
        w2.cliRender();
        System.out.println();

        // ===== SCENE 03: LAYERS =====
        String[] layers = {
                "#########",
                "#.......#",
                "#~~~~~~~#",
                "#ooooooo#",
                "#       #",
                "#########"
        };

        // build a world from the above scene
        World w3 = new World(layers);
        System.out.print("\033[2J"); // clear the screen once before the first frame
        for (int t = 0; t < 5; t++) {
            w3.cliRender();
            Thread.sleep(500);
            w3.step();
        }
        w3.cliRender();
        System.out.println();

        // ===== SCENE 04: DAM =====
        String[] dam = {
                "############",
                "#~~~#      #",
                "#~~~#      #",
                "#~~~#      #",
                "#~~~       #",
                "############"
        };

        // build a world from the above scene
        World w4 = new World(dam);
        System.out.print("\033[2J"); // clear the screen once before the first frame
        for (int t = 0; t < 15; t++) {
            w4.cliRender();
            Thread.sleep(500);
            w4.step();
        }
        w4.cliRender();
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

