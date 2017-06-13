package mapekcosmos.sensors.impl;

import mapekcosmos.sensors.core.SensorM;
import mapekcosmos.sensors.core.SensorMFactory;
import mapekcosmos.sensors.prov.IManager;
import mapekcosmos.sensors.prov.ISensorUpdater;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ISensorUpdaterFacade implements IInterfaceTags, ISensorUpdater {
    private IManager manager = null;
    private SensorM sensor;

    public ISensorUpdaterFacade(IManager manager) {
        this.manager = manager;
        this.sensor = SensorMFactory.createInstance(this.manager);
    }

    @Override public synchronized boolean activateSensor(String name) {
        return sensor.activateSensor(name);
    }

    @Override public synchronized boolean deactivateSensor(String name) {
        return sensor.deactivateSensor(name);
    }
}
