package mapekcosmos.planner.core;

import mapekcosmos.planner.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class PlannerFactory {
    private static Planner sensorM = null;

    public static synchronized Planner createInstance(IManager manager) {
        if (sensorM == null)
            sensorM = new Planner(manager);
        return sensorM;
    }
}
