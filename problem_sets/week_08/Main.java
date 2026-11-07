import simulator.*;

public class Main {
    public static void main(String[] args) {
        String[] drop = {
                "#######",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#     #",
                "#######" };

        // build a world from the above scene
        World w = new World(drop);
        System.out.print(w.render());
        System.out.println(w.get(0,0));
    }
}