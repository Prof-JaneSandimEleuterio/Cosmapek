package mapekcosmos.sensors.core;

import mapekcosmos.sensors.prov.IManager;

/**
 * Created by ArchyWin on 6/16/2015.
 */
public class SensorMFactory {
    private static SensorM sensorM = null;

    public synchronized static SensorM createInstance(IManager manager) {
        if (sensorM == null)
            sensorM = new SensorM(manager);
        return sensorM;
    }
}
