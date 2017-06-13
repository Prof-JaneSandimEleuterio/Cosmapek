package unicamp.buscame.zCosmapek_Sensors;

import unicamp.buscame.zCosmapek_Configurations.IInterfaceTags;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class ProductCSensorThread extends Thread implements IInterfaceTags {
    private unicamp.buscame.productCSensor.prov.IManager productCSensor;
    private unicamp.buscame.productCSensor.prov.ISensorUpdaterManager productCSensorISenUp;
    @Override
    public void run() {
        //super.run();
        productCSensor = unicamp.buscame.productCSensor.impl.ComponentFactory.createInstance();
        productCSensorISenUp =
                (unicamp.buscame.productCSensor.prov.ISensorUpdaterManager) productCSensor.getProvidedInterface(ISensorUpdaterManagerTag);
        productCSensorISenUp.runSensor();
    }
}
