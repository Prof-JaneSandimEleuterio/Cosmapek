package unicamp.buscame.zCosmapek_Sensors;

import unicamp.buscame.zCosmapek_Configurations.IInterfaceTags;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class ConfigurationSensorThread extends Thread implements IInterfaceTags{
    private unicamp.buscame.configurationSensor.prov.IManager configurationSensor;
    private unicamp.buscame.configurationSensor.prov.ISensorUpdaterManager configurationSensorISenUp;
    @Override
    public void run() {
        //super.run();
        configurationSensor = unicamp.buscame.configurationSensor.impl.ComponentFactory.createInstance();
        configurationSensorISenUp =
                (unicamp.buscame.configurationSensor.prov.ISensorUpdaterManager) configurationSensor.getProvidedInterface(ISensorUpdaterManagerTag);
        configurationSensorISenUp.runSensor();
    }
}
