package unicamp.buscame.configurationBSensor.impl;

import unicamp.buscame.configurationBSensor.core.SensorUpdaterM;
import unicamp.buscame.configurationBSensor.core.SensorUpdaterMFactory;

import unicamp.buscame.configurationBSensor.prov.ISensorUpdaterManager;
import unicamp.buscame.configurationBSensor.prov.IManager;
/**
 * Created by ArchyWin on 5/26/2015.
 */
class ISensorUpdaterManagerFacade implements unicamp.buscame.configurationBSensor.impl.IInterfaceTags, ISensorUpdaterManager {
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
