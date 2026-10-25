import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);      // the program's only Scanner
        TicTacToe game = new TicTacToe();

        printBanner();
        System.out.println(game);

        while (!game.isOver()) {
            System.out.print("❯ " + game.currentSymbol() + " to play (row col, 0-2): ");
            int row = readInt(in);
            int col = readInt(in);
            if (!game.play(row, col)) {
                System.out.println("Illegal move, try again.");
                continue;
            }
            System.out.println(game);
        }

        if (game.hasWinner()) {
            printWin(game.winnerSymbol());
        } else {
            System.out.println("--- NO WINNER :( ---");
        }
    }

    private static int readInt(Scanner in) {
        while (!in.hasNextInt()) {
            in.next();                            // discard the bad token, or loop forever
            System.out.print("❯ Please type a number: ");
        }
        return in.nextInt();
    }

    // printBanner() and printWin(char) move here unchanged, marked private static:
    private static void printBanner() {
        System.out.println();
        System.out.println("  X | O | X");
        System.out.println(" ---+---+---");
        System.out.println("  O | X | O     T I C   T A C   T O E");
        System.out.println(" ---+---+---");
        System.out.println("  X | O | X");
        System.out.println();
    }

    private static void printWin(char winner) {
        System.out.println();
        System.out.println("┌────────────────┐");
        System.out.println("│   " + winner + "  W I N S   │");
        System.out.println("└────────────────┘");
        System.out.println();
    }
}
