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

    /**
     * A program is a sequence of tokens separated by one or more spaces. This method executes the program. The following tokens are admitted:
     * F n : forward(n)
     * L d R d : turnLeft(d), turnRight(d)
     * U D : pen up, pen down
     * P c : setPen(c), where c is a single char
     * REPEAT k [...] : execute the body k >= 0 times. The brackets are separate tokens.
     * @param program
     * @return
     */
    public boolean execute(String program)
    {
        // handle null, empty or blank program
        if(program == null || program.trim().isEmpty()) { return true; }

        // extract tokens
        String[] tokens = program.trim().split(" +");
        int n = tokens.length;

        // execute the program
        int i = 0;
        while(i < n)
        {
            String command = tokens[i];
            ++i;

            switch(command)
            {
                case "F":
                    if(!forward(intArgument(tokens, i, command))) return false;
                    ++i;
                    break;

                case "L":
                    if(!turnLeft(intArgument(tokens, i, command))) return false;
                    ++i;
                    break;

                case "R":
                    if(!turnRight(intArgument(tokens, i, command))) return false;
                    ++i;
                    break;

                case "U":
                    penUp();
                    break;

                case "D":
                    penDown();
                    break;

                case "P":
                {
                    if(i >= n) throw new IllegalArgumentException("missing argument after P");
                    String arg = tokens[i];
                    if(arg.length() != 1) throw new IllegalArgumentException("the argument of P must be a single char, got: " + arg);
                    setPen(arg.charAt(0));
                    ++i;
                    break;
                }

                case "REPEAT":
                {
                    // repeat count
                    int k = intArgument(tokens, i, command);
                    if(k < 0) throw new IllegalArgumentException("REPEAT count must be >= 0, got: " + k);
                    ++i;

                    // opening bracket
                    if(i >= n || !tokens[i].equals("[")) throw new IllegalArgumentException("REPEAT must be followed by '['");
                    ++i;
                    int idxStart = i;

                    // find the matching ']' (counting depth so nested REPEATs work)
                    int depth = 1;
                    while(i < n && depth > 0)
                    {
                        if(tokens[i].equals("[")) ++depth;
                        if(tokens[i].equals("]")) --depth;
                        ++i;
                    }
                    if(depth > 0) throw new IllegalArgumentException("REPEAT has no matching ']'");
                    int idxEnd = i - 1; // position of the matching ']'

                    // body of the loop
                    String body = "";
                    for(int j = idxStart; j < idxEnd; ++j)
                    {
                        body = body + tokens[j] + " ";
                    }

                    // execute the body k times
                    for(int rep = 0; rep < k; ++rep)
                    {
                        if(!execute(body)) return false;
                    }
                    break;
                }

                default:
                    throw new IllegalArgumentException("The program is misspecified, unknown command: " + command);
            }
        }

        return true;
    }

    /**
     * Reads tokens[i] as the integer argument of command.
     * Throws IllegalArgumentException if it is missing or not an integer.
     */
    private static int intArgument(String[] tokens, int i, String command)
    {
        if(i >= tokens.length) throw new IllegalArgumentException("missing argument after " + command);
        try {
            return Integer.parseInt(tokens[i]);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("the argument of " + command + " must be an integer, got: " + tokens[i]);
        }
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
