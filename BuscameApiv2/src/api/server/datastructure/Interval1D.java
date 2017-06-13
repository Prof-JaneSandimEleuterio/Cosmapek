package api.server.datastructure;

/**
 * Created by Junior Cupe on 9/4/2015.
 */
public class Interval1D<Key extends Comparable<Key>> {
    private Key low;
    private Key high;

    public Interval1D(Key low, Key high) {
        this.low=low;
        this.high=high;
    }

    public Key getLow() {
        return low;
    }

    public Key getHigh() {
        return high;
    }

    public boolean contains(Key x) {
        return (low.compareTo(x)<=0) && (x.compareTo(high)<=0);
    }

    public String toString() {
        return "[" + low + ", " + high + "]";
    }
}
