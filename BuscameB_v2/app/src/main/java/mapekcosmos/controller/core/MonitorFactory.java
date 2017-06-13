package mapekcosmos.controller.core;

import mapekcosmos.controller.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class MonitorFactory {
    private static Monitor sensorM = null;

    public static synchronized Monitor createInstance(IManager manager) {
        if (sensorM == null)
            sensorM = new Monitor(manager);
        return sensorM;
    }
}
