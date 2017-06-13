package mapekcosmos.conn_sensors_reader.impl;

import mapekcosmos.conn_sensors_reader.prov.IManager;

class Adapter implements mapekcosmos.reader.req.ISensorManager, mapekcosmos.conn_sensors_reader.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void createASensor(String name, String feature, boolean isSensor, int orderT) {
        mapekcosmos.sensors.prov.ISensorManager compSensors =
            (mapekcosmos.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);
        compSensors.createASensor(name, feature, isSensor, orderT);
    }
}
