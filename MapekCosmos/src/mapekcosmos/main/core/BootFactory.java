package mapekcosmos.main.core;

import mapekcosmos.main.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class BootFactory {
    private static Boot sensorM = null;

    public static synchronized Boot createInstance(IManager manager) {
        if (sensorM == null)
            sensorM = new Boot(manager);
        return sensorM;
    }
}
