package unicamp.buscame.zCosmapek_Configurations;

import android.util.Log;

import mapekcosmos.interfaces.IExecution;
import unicamp.buscame.zCosmapek_Sensors.LocalizationBSensorThread;
import unicamp.buscame.zCosmapek_Sensors.LocalizationBSensorThreadFactory;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class LocalizationBSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.localizationBSensor.prov.IManager localizationBSensor;
    private unicamp.buscame.localizationBSensor.prov.ISensorUpdaterManager localizationBSensorISenUp;
    @Override
    public void execute() {
/*        localizationBSensor = unicamp.buscame.localizationBSensor.impl.ComponentFactory.createInstance();
        localizationBSensorISenUp =
                (unicamp.buscame.localizationBSensor.prov.ISensorUpdaterManager) localizationBSensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        LocalizationBSensorThread sensorThread = LocalizationBSensorThreadFactory.createInstance();
      //  sensorThread.start();
        if(!sensorThread.isAlive() && !LocalizationBSensorThreadFactory.wasUsed()){
            LocalizationBSensorThreadFactory.used();
            Log.d("Buscame","Localization B "+ sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}
