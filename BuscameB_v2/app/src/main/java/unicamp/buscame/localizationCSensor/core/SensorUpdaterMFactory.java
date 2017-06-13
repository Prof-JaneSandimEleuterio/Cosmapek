package unicamp.buscame.localizationCSensor.core;

import unicamp.buscame.localizationCSensor.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class SensorUpdaterMFactory {
    private static unicamp.buscame.localizationCSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized unicamp.buscame.localizationCSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new unicamp.buscame.localizationCSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}
