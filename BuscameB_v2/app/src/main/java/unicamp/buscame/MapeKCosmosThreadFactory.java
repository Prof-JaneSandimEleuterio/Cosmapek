package unicamp.buscame;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class MapeKCosmosThreadFactory {
    private static boolean wasUsed=false;
    private static MapeKCosmosThread productSensorThread = null;

    public static synchronized MapeKCosmosThread createInstance(String sdcard_variability, String sdcard_config, String jarPath) {
        if (productSensorThread == null)
            productSensorThread = new MapeKCosmosThread(sdcard_variability,sdcard_config,jarPath);
        return productSensorThread;
    }

    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}
