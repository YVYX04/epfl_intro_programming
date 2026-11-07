package simulator;

/**
 * PARENT CLASS 
 * Element
 */
public class Element
{
    // ___ member variables ___
    private String name; // name of the element
    private char symbol; // symbol of the element
    private int density; // density of the element
    private int last_updated = -1;

    // ___ CONSTRUCTORS ___
    /**
     * Main constructor
     * @param name : name of the element
     * @param symbol : symbol of the element
     * @param density : density of the element
     */
    public Element(String name, char symbol, int density)
    {
        // basic member variables
        this.name = name;
        this.symbol = symbol;
        this.density = density;
    }

    /**
     * Copy constructor
     * @param o: reference of the element to copy
     */
    public Element(Element o) {

        // copy base parameters
        this(o.name, o.symbol, o.density);

        // copy state
        this.last_updated = o.last_updated;
    }

    // ___ GETTERS ___
    // Note: default behavior implemented here, see Override in subclasses for details.
    public String getName()
    {
        return name;
    }
    public char getSymbol()
    {
        return symbol;
    }
    public int getDensity()
    {
        return density;
    }
    public boolean isFluid()
    {
        return false;
    }
    public boolean isFlammable()
    {
        return false;
    }
    public int getBurnTime()
    {
        return 0;
    }

    // ___ SETTERS ___
    /**
     * Records that this element was updated at this tick.
     * @param tick : tick of the update
     */
    public void markUpdated(int tick)
    {
        last_updated = tick;
    }
    public boolean extinguishesFire()
    {
        return false;
    }

    /**
     * 'update' is called by the world when it is this element’s turn to act; the element is at (row,col)
     * in w. It returns true if and only if, during this call, the element moved to another cell or was
     * replaced.
     */
    public boolean update(World w, int row, int col)
    {
        // general behavior of matter that does nothing
        return false;
    }

    // ___ METHODS ___


    // ___ HELPERS ___
    /**
     * Return true if the element was last updated at this tick.
     * @param tick
     * @return boolean
     */
    public boolean wasUpdatedAt(int tick)
    {
        return (tick == last_updated);
    }

    // ___ OVERRIDE ___
    @Override 
    public String toString()
    {
        String out = "";
        out = out + name + " '" + symbol + "' " + "d=" + density;
        return out;
    }
}