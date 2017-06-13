package mapekcosmos.conn_sensors_variability.impl;

import mapekcosmos.conn_sensors_variability.prov.IManager;

import java.util.LinkedList;

class Adapter
    implements mapekcosmos.variability.req.ISensorManager, mapekcosmos.conn_sensors_variability.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        mapekcosmos.sensors.prov.ISensorManager compSensors =
            (mapekcosmos.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);
        compSensors.updateRuntimeRegistry(sol);
    }
}
