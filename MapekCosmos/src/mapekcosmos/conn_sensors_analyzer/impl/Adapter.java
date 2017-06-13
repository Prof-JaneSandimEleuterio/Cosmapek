package mapekcosmos.conn_sensors_analyzer.impl;

import mapekcosmos.conn_sensors_analyzer.prov.IManager;
import mapekcosmos.interfaces.ISensors;

class Adapter implements mapekcosmos.analyzer.req.ISensorManager, mapekcosmos.conn_sensors_analyzer.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized boolean hasSensorsInRuntime() {
        mapekcosmos.sensors.prov.ISensorManager compSensors =
            (mapekcosmos.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);

        return compSensors.hasSensorsInRuntime();
    }

    @Override public synchronized ISensors getSensorsInRuntime() {
        mapekcosmos.sensors.prov.ISensorManager compSensors =
            (mapekcosmos.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);

        return compSensors.getSensorsInRuntime();
    }
}
