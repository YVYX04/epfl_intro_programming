package simulator;

public class Water extends Liquid {

    // ___ CONSTRUCTORS ___
    public Water() {
        super("water", '~', 6, 3);
    }

    // ___ OVERRIDE ___
    @Override
    public boolean extinguishesFire() { return true; }
}