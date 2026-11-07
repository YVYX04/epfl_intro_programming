package simulator;

public class Particle extends Element
{
    // ___ CONSTRUCTORS ___

    /**
     * Base constructor of Particle relies on the one implemented in Element.
     * @param name : name of the particle, e.g. "air"
     * @param symbol : symbol of the particle, e.g. ' '
     * @param density : density of the particle, e.g. 2
     */
    public Particle(String name, char symbol, int density) {
        super(name, symbol, density);
    }

    // ___ METHODS ___
    /**
     * This method is only an API for subclasses.
     * @return gravity unit
     */
    public int getGravity() {
        return 0;
    }

    /**
     * Let g be the gravity of particle p. Then p can enter target iff target is fluid
     * and:
     * g > 0 -> density(target) < density(p) || g < 0 -> density(target) > density(p)
     * @param target : Element in which we try to enter
     * @return : true if this can enter
     */
    public boolean canEnter(Element target) {
        // null target should not exist
        if(target == null) {
            throw new IllegalArgumentException("A target cannot be null.");
        }

        // check target is fluid
        if(!target.isFluid()) { return false; }
        else {
            if(this.getGravity() > 0) {
                return(target.getDensity() < this.getDensity());
            } else {
                return(target.getDensity() > this.getDensity());
            }
        }
    }

    public boolean tryMove(World w, int row, int col, int dRow, int dCol) {
        // check that (r + dr, c + dc) is inside the grid
        if(!w.isInside(row + dRow, col + dCol)) return false;
        // check that the particle can enter there
        if(!canEnter(w.get(row + dRow, col + dCol))) return false;

        // swap if conditions valid
        w.swap(row, col, row + dRow, col + dCol);
        return true;
    }

    // ___ OVERRIDE ___
    @Override
    public boolean update(World w, int i, int j) {
        int s = (w.getTick() % 2 == 0) ? -1 : 1;

        // sequence of move to attempt
        if(tryMove(w, i, j, this.getGravity(), 0)) return true;
        if(tryMove(w, i, j, this.getGravity(), s)) return true;
        return tryMove(w, i, j, this.getGravity(), -s); // false if no move succeeded
    }
}