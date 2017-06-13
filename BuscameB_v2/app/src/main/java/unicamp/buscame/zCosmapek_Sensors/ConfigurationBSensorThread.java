package unicamp.buscame.zCosmapek_Sensors;

import unicamp.buscame.zCosmapek_Configurations.IInterfaceTags;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class ConfigurationBSensorThread  extends Thread implements IInterfaceTags{
    private unicamp.buscame.configurationBSensor.prov.IManager configurationBSensor;
    private unicamp.buscame.configurationBSensor.prov.ISensorUpdaterManager configurationBSensorISenUp;
    @Override
    public void run() {
        //super.run();
        configurationBSensor = unicamp.buscame.configurationBSensor.impl.ComponentFactory.createInstance();
        configurationBSensorISenUp =
                (unicamp.buscame.configurationBSensor.prov.ISensorUpdaterManager) configurationBSensor.getProvidedInterface(ISensorUpdaterManagerTag);

        configurationBSensorISenUp.runSensor();
    }
}
