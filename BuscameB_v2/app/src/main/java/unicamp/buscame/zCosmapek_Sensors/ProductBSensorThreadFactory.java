package unicamp.buscame.zCosmapek_Sensors;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class ProductBSensorThreadFactory {
    private static boolean wasUsed=false;
    private static ProductBSensorThread productBSensorThread = null;

    public static synchronized ProductBSensorThread createInstance() {
        if (productBSensorThread == null)
            productBSensorThread = new ProductBSensorThread();
        return productBSensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}
