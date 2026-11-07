package simulator;

/**
 * PARENT CLASS 
 * Element
 */
public class Element
{
    // ___ class variables ___
    static final private char[] SYMBOLS = {' ', '#', '=', '*', '.', '~', 'o', '"'};
    static final private String[] NAMES = {"air", "wall", "wood", "fire", "sand", "water", "oil", "smoke"};
    static final private int[] DENSITIES = {2, 100, 30, 0, 10, 6, 4, 1};
    static final private boolean[] IS_FLUID = {true, false, false, false, false, true, true, true};
    static final private boolean[] IS_FLAMMABLE = {false, false, true, false, false, false, true, false};
    static final private int[] BURN_UNITS = {10, 3};


    // ___ member variables ___
    private String name; // name of the element
    private char symbol; // symbol of the element
    private int density; // density of the element
    private int last_udpated = -1; // last time of update, each element is init at t = -1.
    private boolean is_fluid;
    private boolean is_flammable;
    private int burn_unit = 0;

    // ___ CONSTRUCTORS ___
    public Element(String name, char symbol, int density)
    {
        // basic member variables
        this.name = name;
        this.symbol = symbol;
        this.density = density;

        // check name exists
        int idx_name = indexName(name);
        if(idx_name == -1) {
            throw new IllegalArgumentException("Element not found! Got : " + name);
        }

        // check symbol match name
        if(SYMBOLS[idx_name] != symbol)
        {
            throw new IllegalArgumentException("Error of initialization for symbol; element " + name + " is not " + symbol);
        }

        // check density match name
        if(DENSITIES[idx_name] != density)
        {
            throw new IllegalArgumentException("Error of initialization for density, element " + name + " is not " + density + " dense.");
        }

        // assign other attributes
        is_fluid = IS_FLUID[idx_name];
        is_flammable = IS_FLAMMABLE[idx_name];
        if(this.isFlammable()) {
            burn_unit = (idx_name == 2) ? BURN_UNITS[0] : BURN_UNITS[1];
        }
        

    }

    // ___ GETTERS ___
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
        return is_fluid;
    }
    public boolean isFlammable()
    {
        return is_flammable;
    }
    public int getBurnTime()
    {
        return burn_unit;
    }

    // ___ SETTERS ___
    /**
     * Mark when the element was last updated
     * @param tick : last time t of update
     */
    public void markUpdated(int tick)
    {
        last_udpated = tick;
    }
    public boolean extinguishesFire()
    {
        return (name.equals("water"));
    } 
    public boolean update(World w, int row, int col)
    {
        // TODO
        return false;
    }

    // ___ METHODS ___


    // ___ HELPERS ___
    /**
     * Return true if the element was last updated at this tick.
     * @param tick
     * @return
     */
    public boolean wasUpdated(int tick)
    {
        return (tick == last_udpated);
    }

    private int indexName(String name)
    {
        for(int i = 0; i < NAMES.length; ++i)
        {
            if(name.equals(NAMES[i])) return i;
        }
        return -1; // not found
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