package unicamp.buscame.productCSensor.impl;

import unicamp.buscame.productCSensor.core.SensorUpdaterM;
import unicamp.buscame.productCSensor.core.SensorUpdaterMFactory;

import unicamp.buscame.productCSensor.prov.ISensorUpdaterManager;
import unicamp.buscame.productCSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ISensorUpdaterManagerFacade implements unicamp.buscame.productCSensor.impl.IInterfaceTags, ISensorUpdaterManager {
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
