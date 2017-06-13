package unicamp.buscame.productBSensor.impl;

import unicamp.buscame.productBSensor.core.SensorUpdaterM;
import unicamp.buscame.productBSensor.core.SensorUpdaterMFactory;

import unicamp.buscame.productBSensor.prov.ISensorUpdaterManager;
import unicamp.buscame.productBSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ISensorUpdaterManagerFacade implements unicamp.buscame.productBSensor.impl.IInterfaceTags, ISensorUpdaterManager {
    private IManager manager = null;
    private SensorUpdaterM sensorUpdaterM;

    ISensorUpdaterManagerFacade(IManager manager) {
        this.manager = manager;
        this.sensorUpdaterM = SensorUpdaterMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized boolean runSensor() {
        return sensorUpdaterM.runSensor();
    }

    @Override
    public synchronized boolean deactivateSensor() {
        return sensorUpdaterM.deactivateSensor();
    }
}
