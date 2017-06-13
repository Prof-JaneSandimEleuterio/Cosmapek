package unicamp.buscame.zCosmapek_Configurations;

import android.util.Log;

import mapekcosmos.interfaces.IExecution;
import unicamp.buscame.zCosmapek_Sensors.ConfigurationSensorThread;
import unicamp.buscame.zCosmapek_Sensors.ConfigurationSensorThreadFactory;

/**
 * Created by ArchyWin on 8/20/2015.
 */
public class  ConfigurationSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.configurationSensor.prov.IManager configurationSensor;
    private unicamp.buscame.configurationSensor.prov.ISensorUpdaterManager configurationSensorISenUp;
    @Override public void execute() {
/*        configurationSensor = unicamp.buscame.configurationSensor.impl.ComponentFactory.createInstance();
        configurationSensorISenUp =
                (unicamp.buscame.configurationSensor.prov.ISensorUpdaterManager) configurationSensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        ConfigurationSensorThread sensorThread = ConfigurationSensorThreadFactory.createInstance();
        if(!sensorThread.isAlive() && !ConfigurationSensorThreadFactory.wasUsed()){
            ConfigurationSensorThreadFactory.used();
            Log.d("Buscame","Configuration A "+ sensorThread.getState().toString());
            sensorThread.start();
        }

    }
}
