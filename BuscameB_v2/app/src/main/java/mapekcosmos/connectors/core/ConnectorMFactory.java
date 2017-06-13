package mapekcosmos.connectors.core;

import mapekcosmos.connectors.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ConnectorMFactory {
    private static ConnectorM sensorM = null;

    public static synchronized ConnectorM createInstance(IManager manager) {
        if (sensorM == null)
            sensorM = new ConnectorM(manager);
        return sensorM;
    }
}
