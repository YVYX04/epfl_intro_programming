/**
 * Tic Tac Toe game's engine
 * @author: Yvan Richard
 * @version: 1.0.0
 */
public class TicTacToe {
    private static final int EMPTY = 0;
    private static final int CIRCLE = 1;
    private static final int CROSS = 2;

    private final int[][] grid = new int[3][3];   // final reference, but the array stays modifiable (leçon 17)
    private int currentPlayer;
    private int moves;
    private int winner;                            // EMPTY while nobody has won

    public TicTacToe() {
        reset();                                   // valid from birth (constructor)
    }

    /** Starts a new game: empty grid, O to play. */
    public void reset() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                grid[i][j] = EMPTY;
            }
        }
        currentPlayer = CIRCLE;
        moves = 0;
        winner = EMPTY;
    }

    /**
     * Plays the current player's mark at (row, col).
     * @param (int) row: the ZERO based index of the played row (0-2).
     * @param (int) col: the ZERO based index of the played column (0-2).
     * @return false if the move is illegal (outside the grid, cell taken, game over);
     *         the state is then unchanged.
     */
    public boolean play(int row, int col) {
        if (isOver() || !inGrid(row, col) || grid[row][col] != EMPTY) {
            return false;
        }
        grid[row][col] = currentPlayer;
        ++moves;
        if (wins(currentPlayer, row, col)) {
            winner = currentPlayer;
        } else {
            // toggle the current player with the ternary operator
            currentPlayer = (currentPlayer == CIRCLE) ? CROSS : CIRCLE;
        }
        return true;
    }

    public boolean isOver()      { return winner != EMPTY || moves == 9; }
    public boolean hasWinner()   { return winner != EMPTY; }
    public char winnerSymbol()   { return symbol(winner); }        // ' ' if no winner
    public char currentSymbol()  { return symbol(currentPlayer); }

    /** Text display of the grid; println(game) calls it automatically (leçon 9). */
    public String toString() {
        String s = "";
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                s += "[" + symbol(grid[i][j]) + "] ";
            }
            s += "\n";
        }
        return s;
    }

    // ----- implementation details -----
    private boolean inGrid(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    private char symbol(int cell) {
        if (cell == CIRCLE) return 'O';
        if (cell == CROSS)  return 'X';
        return ' ';
    }

    private boolean wins(int p, int row, int col) {
        if (grid[row][0] == p && grid[row][1] == p && grid[row][2] == p) return true;
        if (grid[0][col] == p && grid[1][col] == p && grid[2][col] == p) return true;
        if (row == col     && grid[0][0] == p && grid[1][1] == p && grid[2][2] == p) return true;
        if (row + col == 2 && grid[0][2] == p && grid[1][1] == p && grid[2][0] == p) return true;
        return false;
    }
}