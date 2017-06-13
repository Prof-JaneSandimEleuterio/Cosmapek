package unicamp.buscame.localizationBSensor.core;

import unicamp.buscame.localizationBSensor.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class SensorUpdaterMFactory {
    private static unicamp.buscame.localizationBSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized unicamp.buscame.localizationBSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new unicamp.buscame.localizationBSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}
