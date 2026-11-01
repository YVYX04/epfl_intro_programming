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
    }
}
