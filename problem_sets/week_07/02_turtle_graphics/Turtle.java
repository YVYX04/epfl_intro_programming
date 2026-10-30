/**
 * Turtle class
 * @author Yvan Richard
 * @version 0.0.1
 */

public class Turtle
{
    // ___ static variables ___
    private static final int[] headings = {0, 45, 90, 135, 180, 225, 270, 315};
    private static final String[] directions = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

    // ___ member variables ___
    private final Canvas canvas; // the canvas the turtle draws on.
    private int x; // column position of the turtle
    private int y; // row position of the turtle
    private int heading;
    private boolean penDown; // true if the pen is down
    private char penChar; // the char drawn by the turtle

    // ___ CONSTRUCTORS ___
    /**
     * Main constructor of the Turtle class
     * @param canvas : the canvas the turtle will draw on.
     * @param x : the column position of the turtle.
     * @param y : the row position of the turtle.
     */
    public Turtle(Canvas canvas, int x, int y)
    {
        // forbid null canvas
        if(canvas == null)
        {
            throw new IllegalArgumentException("Canvas object must not be null.");
        }

        this.canvas = canvas;

        // check x and y coordinates are inside the canvas
        if(!(canvas.isInside(x, y)))
        {
            throw new IllegalArgumentException("The turtle must be positioned inside the canvas, got x = " + x + ", y = " + y);
        }

        this.x = x;
        this.y = y;

        // init other variables
        heading = headings[0];
        penDown = true;
        penChar = '*';
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
        this(o.canvas, o.x, o.y);
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
        if(n < 0) return false;

        // draw on the canvas if the pen is down
        if(penDown)
        {
            // TODO
        }

    }


}
