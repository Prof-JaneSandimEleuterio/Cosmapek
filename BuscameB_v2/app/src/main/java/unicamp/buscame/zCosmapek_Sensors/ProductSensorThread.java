package unicamp.buscame.zCosmapek_Sensors;

import unicamp.buscame.zCosmapek_Configurations.IInterfaceTags;

/**
 * @author ArchyWin on 9/15/2015.
 */
public class ProductSensorThread extends Thread implements IInterfaceTags {
    private unicamp.buscame.productSensor.prov.IManager productSensor;
    private unicamp.buscame.productSensor.prov.ISensorUpdaterManager productSensorISenUp;
    @Override
    public void run() {
        //super.run();
        productSensor = unicamp.buscame.productSensor.impl.ComponentFactory.createInstance();
        productSensorISenUp =
                (unicamp.buscame.productSensor.prov.ISensorUpdaterManager) productSensor.getProvidedInterface(ISensorUpdaterManagerTag);
        productSensorISenUp.runSensor();
    }
}
