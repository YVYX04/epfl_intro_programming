package simulator;

public class Oil extends Liquid {

    // ___ CONSTRUCTORS ___
    public Oil() {
        super("oil", 'o', 4, 1);
    }

    // ___ OVERRIDE ___
    @Override
    public int getBurnTime() {
        return 3;
    }

}