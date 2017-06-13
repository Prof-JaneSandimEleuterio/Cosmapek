package unicamp.buscame.productBSensor.core;

import unicamp.buscame.productBSensor.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class SensorUpdaterMFactory {
    private static unicamp.buscame.productBSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized unicamp.buscame.productBSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new unicamp.buscame.productBSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}
