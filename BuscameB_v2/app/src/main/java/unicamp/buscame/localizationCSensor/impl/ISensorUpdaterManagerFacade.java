package unicamp.buscame.localizationCSensor.impl;

import unicamp.buscame.localizationCSensor.core.SensorUpdaterM;
import unicamp.buscame.localizationCSensor.core.SensorUpdaterMFactory;
import unicamp.buscame.localizationCSensor.prov.ISensorUpdaterManager;
import unicamp.buscame.localizationCSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ISensorUpdaterManagerFacade implements unicamp.buscame.localizationCSensor.impl.IInterfaceTags, ISensorUpdaterManager {
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
