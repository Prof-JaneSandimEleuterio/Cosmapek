package unicamp.buscame.zCosmapek_Sensors;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class LocalizationSensorThreadFactory {
    private static boolean wasUsed=false;
    private static LocalizationSensorThread localizationSensorThread = null;

    public static synchronized LocalizationSensorThread createInstance() {
        if (localizationSensorThread == null)
            localizationSensorThread = new LocalizationSensorThread();
        return localizationSensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}
