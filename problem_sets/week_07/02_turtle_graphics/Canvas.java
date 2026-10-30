/**
 * Canvas class
 * @author Yvan Richard
 * @version 0.0.1
 */

public class Canvas
{
    // ___ member variables ___
    private static final char BLANK = '.';
    private final char[][] grid; // canvas on which we will draw ASCII chars
    private final int height;
    private final int width;

    // ___ CONSTRUCTORS ___
    /**
     * Main constructor of the Canvas class. All cells of the canvas are init to '.' == BLANK.
     * @param width : number of columns
     * @param height : number of rows
     */
    public Canvas(int width, int height)
    {
        // any dimension smaller than 1 is rejected
        if(width < 1)
        {
            throw new IllegalArgumentException("Canvas width must be >= 1, got: " + width);
        }
        if(height < 1)
        {
            throw new IllegalArgumentException("Canvas height must be >= 1, got: " + height);
        }

        // assign dimensions and reference to grid
        this.width = width;
        this.height = height;
        grid = new char[height][width];

        // init grid to BLANK
        clear();
    }

    /**
     * Copy constructor
     */
    public Canvas(Canvas o)
    {
        this(o.width, o.height);
    }

    /**
     * Default constructor with a grid 21 x 11
     */
    public Canvas()
    {
        this(21, 11);
    }

    // ___ GETTERS ___
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    // ___ TOOLS ___
    /**
     * Write a given char in the grid at given coordinates if inside, else does nothing.
     * @param x : col
     * @param y : row
     * @param c : char
     * @return : true if success to write, false otherwise.
     */
    public boolean plot(int x, int y, char c)
    {
        if(isInside(x, y))
        {
            grid[y][x] = c;
            return true;
        } else {
            return false;
        }
    }

    // ___ OPERATORS ___
    /**
     * Check it two canvas are equal, i.e. share the same dimensions and each cell is filled with the
     * same character.
     * @param o
     * @return
     */
    public boolean equals(Canvas o)
    {
        // null case
        if(o == null) return false;

        // same dimensions
        if(o.width != width) return false;
        if(o.height != height) return false;

        // grid scan
        for(int i = 0; i < height; ++i)
        {
            for(int j = 0; j < width; ++j)
            {
                if(this.charAt(i, j) != o.charAt(i, j)) return false;
            }
        }

        return true;   
    }


    // ___ HELPERS ___
    /**
     * Reset the grid to only BLANK values.
     */
    private void clear()
    {
        for(int i = 0; i < height; ++i)
        {
            for(int j = 0; j < width; ++j)
            {
                grid[i][j] = BLANK;
            }
        }
    }

    /**
     * Check if a given (zero based) coordinate is in the Canvas.
     * @param x : column x
     * @param y : row y
     */
    private boolean isInside(int x, int y)
    {
        return ((x >= 1 && x < width) && (y >= 1 && y < height));
    }

    /**
     * Return the char at column x and row y
     * @param x : col
     * @param y : row
     * @return : the char at grid[y][x]
     */
    public char charAt(int x, int y)
    {
        if(isInside(x, y))
        {
            return grid[y][x];
        } else {
            return BLANK;
        }
    }

    /**
     * Number of non-blank cells.
     * @return the number of filled cells.
     */
    public int inkCount()
    {
        int inkCount = 0;
        for(int i = 0; i < height; ++i)
        {
            for(int j = 0; j < width; ++j)
            {
                if(grid[i][j] != BLANK) { ++inkCount; }
            }
        }
        return inkCount;
    }

    /**    (non-Javadoc)
     * overwrite of {@link Object#toString()}
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        String out = new String();
        for(int i = 0; i < height; ++i)
        {
            for(int j = 0; j < width; ++j)
            {
                out += (grid[i][j] + '\n');
            }
        }
        return out;
    }
}