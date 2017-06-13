package unicamp.buscame.zCosmapek_Sensors;

import unicamp.buscame.zCosmapek_Configurations.IInterfaceTags;

/**
 * @author Junior Cupe Casquina on 9/15/2015.
 */
public class LocalizationBSensorThread extends Thread implements IInterfaceTags {
    private unicamp.buscame.localizationBSensor.prov.IManager localizationBSensor;
    private unicamp.buscame.localizationBSensor.prov.ISensorUpdaterManager localizationBSensorISenUp;
    @Override
    public void run() {
       // super.run();
        localizationBSensor = unicamp.buscame.localizationBSensor.impl.ComponentFactory.createInstance();
        localizationBSensorISenUp =
                (unicamp.buscame.localizationBSensor.prov.ISensorUpdaterManager) localizationBSensor.getProvidedInterface(ISensorUpdaterManagerTag);
        localizationBSensorISenUp.runSensor();
    }
}
