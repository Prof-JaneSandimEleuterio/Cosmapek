package unicamp.buscame.configurationBSensor.core;

import unicamp.buscame.configurationBSensor.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class SensorUpdaterMFactory {
    private static unicamp.buscame.configurationBSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized unicamp.buscame.configurationBSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new unicamp.buscame.configurationBSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}
