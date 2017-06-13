package unicamp.buscame.zCosmapek_Sensors;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class ConfigurationBSensorThreadFactory {
    private static boolean wasUsed=false;
    private static ConfigurationBSensorThread configurationBSensorThread = null;

    public static synchronized ConfigurationBSensorThread createInstance() {
        if (configurationBSensorThread == null)
            configurationBSensorThread = new ConfigurationBSensorThread();
        return configurationBSensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}
