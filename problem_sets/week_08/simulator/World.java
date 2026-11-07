package simulator;

public class World {
    
    // ___ member variables ___
    private Element[][] world;
    private int nRows; // number of rows in the grid
    private int nCols; // number of cols in the grid
    private int tick = -1;

    // ___ CONSTRUCTORS ___

    /**
     * Main constructor for the World() class.
     * Precondition: lines is non-empty, one string per row, all of equal length.
     */
    public World(String[] lines) {

        // assign nRows and nCols
        nRows = lines.length;
        nCols = lines[0].length();

        // allocate space for the grid of elements
        world = new Element[nRows][nCols];

        // the time now becomes t = 0
        tick = 0;

        // Fill the world
        for(int i = 0; i < nRows; ++i) {
            for(int j = 0; j < nCols; ++j) {
                // symbol
                char symbol = lines[i].charAt(j);

                // element
                set(i, j, this.createElement(symbol));

            }
        }


    }

    // ___ GETTERS ___
    public int getRows() { return nRows; }
    public int getCols() { return nCols; }
    public int getTick() { return tick; }
    /**
     * Precondition: isInside(i, j).
     * Returns the element itself (not a copy): callers must act on the real element.
     */
    public Element get(int i, int j) {
        return world[i][j];
    }

    // ___ SETTERS ___
    /**
     * Stores e in the cell and marks e as updated at the current
     * tick.
     * @param i : row
     * @param j : column
     * @param e : element to be stored in cell (i, j) of the world
     * Precondition: isInside(i, j).
     */
    public void set(int i, int j, Element e) {
        // set world[i][j] as pointing to e
        world[i][j] = e;

        // mark e as updated at the current tick
        e.markUpdated(tick);
    }

    public void swap(int i1, int j1, int i2, int j2) {
        Element temp = world[i1][j1];
        world[i1][j1] = world[i2][j2];
        world[i2][j2] = temp;
    }

    // ___ RUNNERS ___
    /**
     * 1. Increment the tick; call its new value t.
     * 2. For i = nRows - 1 down to 0, and for j = 0, up to j = nCols - 1,
     * let e be the element in the cell (i, j) at that moment. If e was updated at tick t, skip it.
     * Otherwise, mark e as updated at t, then call e.update(this, r, c)
     */
    public void step() {
        // new time
        int t = tick + 1;
        tick = t;

        for(int i = nRows - 1; i >= 0; --i) {
            for(int j = 0; j < nCols; ++j) {
                Element e = this.get(i, j);
                if(!e.wasUpdatedAt(t)) {
                    e.markUpdated(t);
                    e.update(this, i, j);
                }
            }
        }
    }

    /**
     * Runs n ticks.
     * @param n : number of ticks
     */
    public void run(int n) {
        for(int k = 0; k < n; ++k) {
            step();
        }
    }

    // ___ COUNTERS ___
    /**
     * Number of cells whose element has this name.
     * @param name : name of the element to count
     * @return number of matching cells
     */
    public int count(String name) {
        int n = 0;
        for(int i = 0; i < nRows; ++i) {
            for(int j = 0; j < nCols; ++j) {
                if(world[i][j].getName().equals(name)) {
                    ++n;
                }
            }
        }
        return n;
    }

    // ___ RENDERS __
    // Precondition: 0 <= row < getRows().
    public String renderRow(int row) {
        String out = "";
        for(int j = 0; j < nCols; ++j) {
            out = out + this.get(row, j).getSymbol();
        }
        return out;
    }
    public String render() {
        String out = "";
        for(int i = 0; i < nRows; ++i) {
            out = out + renderRow(i) + "\n";
        }
        return out;
    }

    private static final String RESET  = "\033[0m";
    private static final String DIM    = "\033[2m";
    private static final String ACCENT = "\033[38;5;209m";

    /**
     * Redraws the whole world in place (top-left of the terminal) with the current tick.
     * Needs a real terminal: IDE consoles usually ignore the cursor-move escape code.
     */
    public void cliRender() {
        StringBuilder sb = new StringBuilder();
        String bar = "─".repeat(nCols);

        sb.append("\033[H"); // cursor to top-left, draw over the last frame
        sb.append(DIM).append('╭').append(bar).append('╮').append(RESET).append('\n');
        for (int i = 0; i < nRows; i++) {
            sb.append(DIM).append('│').append(RESET)
              .append(renderRow(i))
              .append(DIM).append('│').append(RESET).append('\n');
        }
        sb.append(DIM).append('╰').append(bar).append('╯').append(RESET).append('\n');
        sb.append(' ').append(ACCENT).append("✻ ").append(RESET)
          .append("time ").append(tick)
          .append(DIM).append(" · ctrl+c to quit").append(RESET);
        sb.append("\033[J"); // erase any leftovers below
        System.out.print(sb);
        System.out.flush();
    }


    // ___ HELPERS ___
    public boolean isInside(int i, int j) {
        if(i < 0 || i >= nRows) return false;
        return j >= 0 && j < nCols;
    }

    /**
     * If the symbol is not recognized, Air will be created
     * @param symbol : symbol of the element
     * @return element
     */
    private Element createElement(char symbol) {
        switch(symbol) {
            case '#':
                return new Wall();
            case '.':
                return new Sand();
            case '~':
                return new Water();
            case 'o':
                return new Oil();
            default:
                return new Air();
        }
    }




}
