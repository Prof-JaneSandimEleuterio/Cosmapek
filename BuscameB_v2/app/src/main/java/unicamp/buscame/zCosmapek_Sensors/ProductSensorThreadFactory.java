package unicamp.buscame.zCosmapek_Sensors;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class ProductSensorThreadFactory {
    private static boolean wasUsed=false;
    private static ProductSensorThread productSensorThread = null;

    public static synchronized ProductSensorThread createInstance() {
        if (productSensorThread == null)
            productSensorThread = new ProductSensorThread();
        return productSensorThread;
    }

    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}
