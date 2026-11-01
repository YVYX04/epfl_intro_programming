/**
 * Turtle class
 * @author Yvan Richard
 * @version 0.0.1
 */

public class Turtle
{
    // ___ static variables ___
    private static final int[][] headings = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}}; // (\Delta x, \Delta y)
    private static final String[] directions = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

    // ___ member variables ___
    private final Canvas canvas; // the canvas the turtle draws on.
    private int x; // column position of the turtle
    private int y; // row position of the turtle
    private int heading; // store the index of the direction
    private boolean penDown; // true if the pen is down
    private char penChar; // the char drawn by the turtle

    // ___ CONSTRUCTORS ___
    /**
     * Private constructor that sets the full state without any check.
     * Used by the public constructors, so a copy works even when the turtle is off the canvas.
     */
    private Turtle(Canvas canvas, int x, int y, int heading, boolean penDown, char penChar)
    {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        this.heading = heading;
        this.penDown = penDown;
        this.penChar = penChar;
    }

    /**
     * Main constructor of the Turtle class: heading N, pen down, pen char '*'.
     * @param canvas : the canvas the turtle will draw on.
     * @param x : the column position of the turtle.
     * @param y : the row position of the turtle.
     */
    public Turtle(Canvas canvas, int x, int y)
    {
        // this(...) must come first, so the checks run right after it
        this(canvas, x, y, 0, true, '*');

        // forbid null canvas
        if(canvas == null)
        {
            throw new IllegalArgumentException("Canvas object must not be null.");
        }

        // check x and y coordinates are inside the canvas
        if(!(canvas.isInside(x, y)))
        {
            throw new IllegalArgumentException("The turtle must be positioned inside the canvas, got x = " + x + ", y = " + y);
        }
    }

    /**
     * Constructor to start at the center of the canvas.
     * @param canvas
     */
    public Turtle(Canvas canvas)
    {
        this(canvas, (canvas.getWidth() / 2), (canvas.getHeight() / 2));
    }

    /**
     * Copy constructor; same state, and the same canvas (shared, not copied).
     * @param o : other Turtle object
     */
    public Turtle(Turtle o)
    {
        // same canvas (shared reference) and same state, no position check
        this(o.canvas, o.x, o.y, o.heading, o.penDown, o.penChar);
    }

    // ___ GETTERS ___
    public int getX() { return x; }
    public int getY() { return y; }
    public int getHeading() { return heading; }
    public boolean isPenDown() { return penDown; }

    // ___ SETTERS ___
    public void penUp() { penDown = false; }
    public void penDown() { penDown = true; }
    public void setPen(char c) {penChar = c; }

    /**
     * Update the turtle direction by rotating it clockwise with an angle deg.
     * @param deg : may be any multiple of 45, including negative values and values ≥360.
     * @return true if successful operation
     */
    public boolean turnRight(int deg)
    {
        int remainder = deg % 45;
        if(remainder != 0) {
            throw new IllegalArgumentException("the angle deg must be a multiple of 45, got: " + deg);
        }

        // update heading index
        int newIndex = (heading + (deg / 45)) % 8;
        if(newIndex < 0) newIndex += 8;
        heading = newIndex;
        return true;
    }

    /**
     * Update the turtle direction by rotating it counter-clockwise with an angle deg.
     * @param deg : angle of rotation
     * @return true if successful operation
     */
    public boolean turnLeft(int deg)
    {
        turnRight(-deg);
        return true;
    }

    // ___ TOOLS ___
    /**
     * If n < 0, return false and do nothing. Otherwise, if the pen is down, first plot the current
     * cell. Then repeat n times move one cell in the direction of the heading, and plot the new cell
     * if the pen is down.
     * @param n
     * @return
     */
    public boolean forward(int n)
    {
        if(n < 0) {
            throw new IllegalArgumentException("n must be >= 0, got n = " + n);
        }

        // draw in the current cell (only edit the grid if (x, y) is inside the canvas)
        if(penDown) { canvas.plot(x, y, penChar); }

        // draw on the canvas if the pen is down, else only update the position
        while(n > 0)
        {
            // move in the direction of the heading
            x += headings[heading][0];
            y += headings[heading][1];

            // plot (only edit grid if (x,y) is inside the canvas)
            if(penDown) { canvas.plot(x, y, penChar); }

            // update n
            --n;
        }

        return true;

    }

    // ___ HELPERS ___
    public String toString()
    {
        String out = new String();
        out += "Turtle at ";

        // coordinates
        out += "(" + x + ", " + y + ") ";

        // direction
        out += " heading " + directions[heading] + " ";

        // pen state 
        out += (penDown) ? "pen down " : "pen up ";

        // char
        out += "'" + penChar + "'";

        return out;
    }


}
