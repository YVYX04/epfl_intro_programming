package simulator;

public class Liquid extends Particle {

    // ___ member variables ___
    private int spread;
    private int direction = 1;

    // ___ CONSTRUCTORS ___
    public Liquid(String name, char symbol, int density, int spread) {
        super(name, symbol, density);
        this.spread = spread;
    }

    // ___ GETTERS ___
    public int getSpread() { return spread; }
    public int getDirection() { return direction; }

    // ___ METHODS ___
    public boolean flows(World w, int i, int j) {
        int nMoves = 0;
        int c = j;
        while(nMoves < spread) {
            boolean m = tryMove(w, i, c, 0, direction);
            if(m) {
                ++nMoves;
                c += direction; // update column
            } else break;
        }
        return (nMoves > 0);
    }

    // ___ OVERRIDE ___
    @Override
    public boolean isFluid() { return true; }

    @Override
    public boolean update(World w, int i, int j) {
        // 1. try the general movement rule of a particle
        if(super.update(w, i, j)) return true;

        // 2. otherwise flows()
        boolean f1 = flows(w, i, j);

        // 3. if it has not moved, direction is reversed and we flows again
        if(!f1) {
            direction *= -1;
            return flows(w, i, j);
        } else return true;
    }

    @Override
    public String toString() {
        return super.toString() + " spread=" + spread + " dir=" + direction;
    }

    @Override
    public int getGravity() {
        return 1;
    }

}