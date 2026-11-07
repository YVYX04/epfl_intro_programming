package simulator;

public class Air extends Element {

    // ___ CONSTRUCTORS ___
    /**
     * Default constructor
     */
    public Air()
    {
        super("air", ' ', 2);
    }

    // ___ OVERRIDE ___
    @Override
    public boolean isFluid() { return true; }
}
