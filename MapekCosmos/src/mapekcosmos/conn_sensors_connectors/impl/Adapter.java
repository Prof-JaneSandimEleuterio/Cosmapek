package mapekcosmos.conn_sensors_connectors.impl;

import mapekcosmos.conn_sensors_connectors.prov.IManager;
import mapekcosmos.interfaces.ISensor;

import java.util.LinkedList;

class Adapter
    implements mapekcosmos.connectors.req.ISensorManager, mapekcosmos.conn_sensors_connectors.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized LinkedList<ISensor> getSensorsWith(String feature) {
        mapekcosmos.sensors.prov.ISensorManager compSensors =
            (mapekcosmos.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);
        return compSensors.getSensorsWith(feature);
    }

    @Override public synchronized boolean hasSensorsWith(String feature) {
        mapekcosmos.sensors.prov.ISensorManager compSensors =
            (mapekcosmos.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);
        return compSensors.hasSensorsWith(feature);
    }
}
