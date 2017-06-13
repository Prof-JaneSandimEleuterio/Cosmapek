package unicamp.buscame.localizationSensor.impl;

import unicamp.buscame.localizationSensor.core.SensorUpdaterM;
import unicamp.buscame.localizationSensor.core.SensorUpdaterMFactory;
import unicamp.buscame.localizationSensor.prov.ISensorUpdaterManager;
import unicamp.buscame.localizationSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ISensorUpdaterManagerFacade implements unicamp.buscame.localizationSensor.impl.IInterfaceTags, ISensorUpdaterManager {
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
