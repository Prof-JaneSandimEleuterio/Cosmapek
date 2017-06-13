package mapekcosmos.sensors.impl;

import mapekcosmos.interfaces.ISensor;
import mapekcosmos.interfaces.ISensors;
import mapekcosmos.sensors.core.SensorM;
import mapekcosmos.sensors.core.SensorMFactory;
import mapekcosmos.sensors.prov.IManager;
import mapekcosmos.sensors.prov.ISensorManager;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ISensorManagerFacade implements IInterfaceTags, ISensorManager {
    private IManager manager = null;
    private SensorM sensor;

    public ISensorManagerFacade(IManager manager) {
        this.manager = manager;
        this.sensor = SensorMFactory.createInstance(this.manager);
    }

    @Override public synchronized void createASensor(String name, String feature, boolean isSensor, int orderT) {
        sensor.createASensor(name, feature, isSensor, orderT);
    }

    @Override public synchronized LinkedList<ISensor> getSensorsWith(String feature) {
        return sensor.getSensorsWith(feature);
    }

    @Override public synchronized boolean hasSensorsWith(String feature) {
        return sensor.hasSensorsWith(feature);
    }

    @Override public synchronized boolean hasSensorsInRuntime() {
        return sensor.hasSensorsInRuntime();
    }

    @Override
    public synchronized boolean hasSensors() {
        return sensor.hasSensors();
    }

    @Override public synchronized ISensors getSensorsInRuntime() {
        return sensor.getSensorsInRuntime();
    }

    @Override
    public synchronized ISensors getSensors() {
        return sensor.getSensors();
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        sensor.updateRuntimeRegistry(sol);
    }

    @Override public synchronized void clearSensors() {
        sensor.clearSensors();
    }
}
