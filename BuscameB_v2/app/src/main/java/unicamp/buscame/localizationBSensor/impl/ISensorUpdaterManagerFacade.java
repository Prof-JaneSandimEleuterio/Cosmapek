package unicamp.buscame.localizationBSensor.impl;

import unicamp.buscame.localizationBSensor.core.SensorUpdaterM;
import unicamp.buscame.localizationBSensor.core.SensorUpdaterMFactory;
import unicamp.buscame.localizationBSensor.prov.ISensorUpdaterManager;
import unicamp.buscame.localizationBSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ISensorUpdaterManagerFacade implements unicamp.buscame.localizationBSensor.impl.IInterfaceTags, ISensorUpdaterManager {
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
