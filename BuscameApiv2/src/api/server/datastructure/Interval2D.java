package api.server.datastructure;

/**
 * Created by Junior Cupe on 9/4/2015.
 */
public class Interval2D<Key extends Comparable<Key>> {

    private Interval1D<Key> intervalX;
    private Interval1D<Key> intervalY;

    public Interval2D(Interval1D<Key> intX, Interval1D<Key> intY) {
        this.intervalX=intX;
        this.intervalY=intY;
    }

    public Key getIntervalX_Low() {
        return intervalX.getLow();
    }

    public Key getIntervalY_Low() {
        return intervalY.getLow();
    }

    public Key getIntervalX_High() {
        return intervalX.getHigh();
    }

    public Key getIntervalY_High() {
        return intervalY.getHigh();
    }

    public boolean contains(Key x, Key y) {
        return intervalX.contains(x) && intervalY.contains(y);
    }
    public String toString() {
        return intervalX + " x " + intervalY + " y ";
    }
}
