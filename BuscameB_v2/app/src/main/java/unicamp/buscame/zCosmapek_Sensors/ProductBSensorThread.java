package unicamp.buscame.zCosmapek_Sensors;

import unicamp.buscame.zCosmapek_Configurations.IInterfaceTags;

/**
 * @author Junior Cupe Casquina on 9/15/2015.
 */
public class ProductBSensorThread extends Thread implements IInterfaceTags {
    private unicamp.buscame.productBSensor.prov.IManager productBSensor;
    private unicamp.buscame.productBSensor.prov.ISensorUpdaterManager productBSensorISenUp;
    @Override
    public void run() {
        //super.run();
        productBSensor = unicamp.buscame.productBSensor.impl.ComponentFactory.createInstance();
        productBSensorISenUp =
                (unicamp.buscame.productBSensor.prov.ISensorUpdaterManager) productBSensor.getProvidedInterface(ISensorUpdaterManagerTag);
        productBSensorISenUp.runSensor();
    }
}
