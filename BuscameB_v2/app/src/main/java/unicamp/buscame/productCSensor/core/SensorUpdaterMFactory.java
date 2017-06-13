package unicamp.buscame.productCSensor.core;

import unicamp.buscame.productCSensor.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class SensorUpdaterMFactory {
    private static unicamp.buscame.productCSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized unicamp.buscame.productCSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new unicamp.buscame.productCSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}
