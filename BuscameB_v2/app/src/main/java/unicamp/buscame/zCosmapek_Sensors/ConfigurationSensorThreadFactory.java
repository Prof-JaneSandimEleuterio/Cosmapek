package unicamp.buscame.zCosmapek_Sensors;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class ConfigurationSensorThreadFactory {
    private static boolean wasUsed=false;
    private static ConfigurationSensorThread configurationSensorThread = null;

    public static synchronized ConfigurationSensorThread createInstance() {
        if (configurationSensorThread == null)
            configurationSensorThread = new ConfigurationSensorThread();
        return configurationSensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}
