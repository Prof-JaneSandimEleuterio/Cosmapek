package unicamp.buscame.zCosmapek_Sensors;

import unicamp.buscame.zCosmapek_Configurations.IInterfaceTags;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class LocalizationSensorThread extends Thread implements IInterfaceTags {
    private unicamp.buscame.localizationSensor.prov.IManager localizationSensor;
    private unicamp.buscame.localizationSensor.prov.ISensorUpdaterManager localizationSensorISenUp;
    @Override
    public void run() {
        //super.run();
        localizationSensor = unicamp.buscame.localizationSensor.impl.ComponentFactory.createInstance();
        localizationSensorISenUp =
                (unicamp.buscame.localizationSensor.prov.ISensorUpdaterManager) localizationSensor.getProvidedInterface(ISensorUpdaterManagerTag);
        localizationSensorISenUp.runSensor();
    }
}
