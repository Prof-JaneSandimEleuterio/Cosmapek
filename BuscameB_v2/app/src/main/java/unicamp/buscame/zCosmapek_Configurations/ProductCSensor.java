package unicamp.buscame.zCosmapek_Configurations;

import android.util.Log;

import mapekcosmos.interfaces.IExecution;
import unicamp.buscame.zCosmapek_Sensors.ProductCSensorThread;
import unicamp.buscame.zCosmapek_Sensors.ProductCSensorThreadFactory;
/**
 * @author ArchyWin on 9/14/2015.
 */
public class ProductCSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.productCSensor.prov.IManager productCSensor;
    private unicamp.buscame.productCSensor.prov.ISensorUpdaterManager productCSensorISenUp;
    @Override
    public void execute() {
/*        productCSensor = unicamp.buscame.productCSensor.impl.ComponentFactory.createInstance();
        productCSensorISenUp =
                (unicamp.buscame.productCSensor.prov.ISensorUpdaterManager) productCSensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        ProductCSensorThread sensorThread = ProductCSensorThreadFactory.createInstance();
      //  sensorThread.start();
        if(!sensorThread.isAlive() && !ProductCSensorThreadFactory.wasUsed()){
            ProductCSensorThreadFactory.used();
            Log.d("Buscame","Product C "+ sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}
