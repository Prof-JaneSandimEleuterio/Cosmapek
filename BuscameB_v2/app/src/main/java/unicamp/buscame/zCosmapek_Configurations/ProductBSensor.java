package unicamp.buscame.zCosmapek_Configurations;

import android.util.Log;

import mapekcosmos.interfaces.IExecution;
import unicamp.buscame.zCosmapek_Sensors.ProductBSensorThread;
import unicamp.buscame.zCosmapek_Sensors.ProductBSensorThreadFactory;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class ProductBSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.productBSensor.prov.IManager productBSensor;
    private unicamp.buscame.productBSensor.prov.ISensorUpdaterManager productBSensorISenUp;
    @Override
    public void execute() {
/*        productBSensor = unicamp.buscame.productBSensor.impl.ComponentFactory.createInstance();
        productBSensorISenUp =
                (unicamp.buscame.productBSensor.prov.ISensorUpdaterManager) productBSensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        ProductBSensorThread sensorThread = ProductBSensorThreadFactory.createInstance();
        if(!sensorThread.isAlive() && !ProductBSensorThreadFactory.wasUsed()){
            ProductBSensorThreadFactory.used();
            Log.d("Buscame","Product B "+ sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}
