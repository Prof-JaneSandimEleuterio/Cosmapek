package unicamp.buscame.zCosmapek_Sensors;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class LocalizationCSensorThreadFactory {
    private static boolean wasUsed=false;
    private static LocalizationCSensorThread localizationCSensorThread = null;

    public static synchronized LocalizationCSensorThread createInstance() {
        if (localizationCSensorThread == null)
            localizationCSensorThread = new LocalizationCSensorThread();
        return localizationCSensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}
