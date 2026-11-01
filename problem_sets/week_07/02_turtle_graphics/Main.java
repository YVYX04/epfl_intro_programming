public class Main
{
    public static void main(String[] args)
    {
        // Test 1
        Canvas c = new Canvas(11, 7);
        Turtle t = new Turtle(c);
        System.out.println(t);
        t.forward(2);
        t.turnRight(90);
        t.forward(3);
        System.out.println(t);
        System.out.println(c);
        System.out.println("ink: " + c.inkCount());

        // Test 2
        Canvas sq = new Canvas(9, 6);
        Turtle s = new Turtle(sq, 1, 4);
        System.out.println(s.execute("REPEAT 4 [ F 3 R 90 ]"));
        System.out.println(sq);
        System.out.println(s);

        // Test 3
        Canvas dia = new Canvas(9, 9);
        Turtle d = new Turtle(dia, 4, 0);
        d.setPen('#');
        System.out.println(d.execute("R 135   REPEAT 4 [ F 4 R 90 ]"));
        System.out.println(dia);

        // Test 4
        Canvas small = new Canvas(5, 5);
        Turtle o = new Turtle(small, 2, 2);
        System.out.println(o.execute("F 4 R 180 F 6"));
        System.out.println(small);
        System.out.println(o);
        try {
            System.out.println(o.execute("F 2 X 3") + " " + o);
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getMessage() + " | " + o);
        }

        try {
            System.out.println(o.execute("R 30"));
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getMessage());
        }

        try {
            System.out.println(o.execute("REPEAT 3 [ F 1"));
        } catch (RuntimeException e) {
            System.out.println("error: " + e);
        }

        System.out.println(o.execute(""));

        try {
            System.out.println(o.execute("L 450") + " " + o);
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getMessage() + " | " + o);
        }

        // Test 5
        Canvas shared = new Canvas(15, 5);
        Turtle t1 = new Turtle(shared, 0, 1);
        Turtle t2 = new Turtle(t1);
        System.out.println(t1.equals(t2));
        t1.execute("R 90 F 14");
        t2.execute("P o R 135 F 3 L 45 F 11");
        System.out.println(t1.equals(t2));
        System.out.println(shared);

    }
}
