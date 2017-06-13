package unicamp.buscame.zCosmapek_Configurations;

import android.util.Log;

import mapekcosmos.interfaces.IExecution;
import unicamp.buscame.zCosmapek_Sensors.ProductSensorThread;
import unicamp.buscame.zCosmapek_Sensors.ProductSensorThreadFactory;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class ProductSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.productSensor.prov.IManager productSensor;
    private unicamp.buscame.productSensor.prov.ISensorUpdaterManager productSensorISenUp;
    @Override
    public void execute() {
/*        productSensor = unicamp.buscame.productSensor.impl.ComponentFactory.createInstance();
        productSensorISenUp =
                (unicamp.buscame.productSensor.prov.ISensorUpdaterManager) productSensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        ProductSensorThread sensorThread = ProductSensorThreadFactory.createInstance();
     //   sensorThread.start();
        if(!sensorThread.isAlive() && !ProductSensorThreadFactory.wasUsed()){
            ProductSensorThreadFactory.used();
            Log.d("Buscame","Product A "+ sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}
