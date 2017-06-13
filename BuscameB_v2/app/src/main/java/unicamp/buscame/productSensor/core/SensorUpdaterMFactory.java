package unicamp.buscame.productSensor.core;

import unicamp.buscame.productSensor.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class SensorUpdaterMFactory {
    private static unicamp.buscame.productSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized unicamp.buscame.productSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new unicamp.buscame.productSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}
