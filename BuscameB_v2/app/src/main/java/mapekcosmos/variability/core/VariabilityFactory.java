package mapekcosmos.variability.core;

import mapekcosmos.variability.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class VariabilityFactory {
    private static Variability sensorM = null;

    public static synchronized Variability createInstance(IManager manager) {
        if (sensorM == null)
            sensorM = new Variability(manager);
        return sensorM;
    }
}
