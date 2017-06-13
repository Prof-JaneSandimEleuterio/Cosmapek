package unicamp.buscame.zCosmapek_Sensors;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class LocalizationBSensorThreadFactory {
    private static boolean wasUsed=false;
    private static LocalizationBSensorThread localizationBSensorThread = null;

    public static synchronized LocalizationBSensorThread createInstance() {
        if (localizationBSensorThread == null)
            localizationBSensorThread = new LocalizationBSensorThread();
        return localizationBSensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}
