package unicamp.buscame.zCosmapek_Sensors;

import unicamp.buscame.zCosmapek_Configurations.IInterfaceTags;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class LocalizationCSensorThread extends Thread implements IInterfaceTags {
    private unicamp.buscame.localizationCSensor.prov.IManager localizationCSensor;
    private unicamp.buscame.localizationCSensor.prov.ISensorUpdaterManager localizationCSensorISenUp;
    @Override
    public void run() {
        //super.run();
        localizationCSensor = unicamp.buscame.localizationCSensor.impl.ComponentFactory.createInstance();
        localizationCSensorISenUp =
                (unicamp.buscame.localizationCSensor.prov.ISensorUpdaterManager) localizationCSensor.getProvidedInterface(ISensorUpdaterManagerTag);
       localizationCSensorISenUp.runSensor();
    }
}
