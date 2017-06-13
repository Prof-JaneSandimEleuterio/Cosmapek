package unicamp.buscame.configurationSensor.core;

import unicamp.buscame.configurationSensor.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class SensorUpdaterMFactory {
    private static unicamp.buscame.configurationSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized unicamp.buscame.configurationSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new unicamp.buscame.configurationSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}
