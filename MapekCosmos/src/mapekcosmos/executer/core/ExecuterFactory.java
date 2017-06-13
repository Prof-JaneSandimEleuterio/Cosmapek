package mapekcosmos.executer.core;

import mapekcosmos.executer.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ExecuterFactory {
    private static Executer sensorM = null;

    public static synchronized Executer createInstance(IManager manager) {
        if (sensorM == null)
            sensorM = new Executer(manager);
        return sensorM;
    }
}
