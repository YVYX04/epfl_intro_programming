public class SameLoop {
    public static void main(String[] args) {
        System.out.println("Boucle for :");
        for (int a = 3; a <= 10; a++) {
            System.out.println("a : " + a);
        }

        System.out.println("Boucle do...while :");
        int i = 3;
        do
        {
            System.out.println("i: " + i);
            ++i;
        } while(i <= 10);

        System.out.println("Boucle while :");
        i = 3;
        while(i <= 10)
        {
            System.out.println("i : " + i);
            ++i;
        }
    }
}

