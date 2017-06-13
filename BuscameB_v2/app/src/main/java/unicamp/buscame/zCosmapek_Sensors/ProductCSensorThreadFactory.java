package unicamp.buscame.zCosmapek_Sensors;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class ProductCSensorThreadFactory {
    private static boolean wasUsed=false;
    private static ProductCSensorThread productCSensorThread = null;

    public static synchronized ProductCSensorThread createInstance() {
        if (productCSensorThread == null)
            productCSensorThread = new ProductCSensorThread();
        return productCSensorThread;
    }

    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}
