package unicamp.buscame.localizationSensor.core;

import unicamp.buscame.localizationSensor.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class SensorUpdaterMFactory {
    private static unicamp.buscame.localizationSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized unicamp.buscame.localizationSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new unicamp.buscame.localizationSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}
