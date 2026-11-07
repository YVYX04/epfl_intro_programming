package  simulator;

public class Powder extends Particle {

    // ___ CONSTRUCTORS ___
    public Powder(String name, char symbol, int density) {
        super(name, symbol, density);
    }

    // ___ OVERRIDES ___
    @Override
    public int getGravity() { return 1; }
}