package unicamp.buscame.zCosmapek_Configurations;

import android.util.Log;

import mapekcosmos.interfaces.IExecution;
import unicamp.buscame.zCosmapek_Sensors.LocalizationSensorThread;
import unicamp.buscame.zCosmapek_Sensors.LocalizationSensorThreadFactory;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class LocalizationSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.localizationSensor.prov.IManager localizationSensor;
    private unicamp.buscame.localizationSensor.prov.ISensorUpdaterManager localizationSensorISenUp;
    @Override
    public void execute() {
/*        localizationSensor = unicamp.buscame.localizationSensor.impl.ComponentFactory.createInstance();
        localizationSensorISenUp =
                (unicamp.buscame.localizationSensor.prov.ISensorUpdaterManager) localizationSensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        LocalizationSensorThread sensorThread = LocalizationSensorThreadFactory.createInstance();
       // sensorThread.start();
        if(!sensorThread.isAlive() && !LocalizationSensorThreadFactory.wasUsed()){
            LocalizationSensorThreadFactory.used();
            Log.d("Buscame","Localization A "+ sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}
