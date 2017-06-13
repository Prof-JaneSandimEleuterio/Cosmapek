package unicamp.buscame.configurationSensor.impl;

import unicamp.buscame.configurationSensor.core.SensorUpdaterM;
import unicamp.buscame.configurationSensor.core.SensorUpdaterMFactory;

import unicamp.buscame.configurationSensor.prov.ISensorUpdaterManager;
import unicamp.buscame.configurationSensor.prov.IManager;
/**
 * Created by ArchyWin on 5/26/2015.
 */
class ISensorUpdaterManagerFacade implements unicamp.buscame.configurationSensor.impl.IInterfaceTags, ISensorUpdaterManager {
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
