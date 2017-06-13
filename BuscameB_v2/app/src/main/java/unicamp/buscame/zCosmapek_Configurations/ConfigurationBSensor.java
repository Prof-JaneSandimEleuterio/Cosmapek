package unicamp.buscame.zCosmapek_Configurations;

import android.util.Log;

import mapekcosmos.interfaces.IExecution;
import unicamp.buscame.zCosmapek_Sensors.ConfigurationBSensorThread;
import unicamp.buscame.zCosmapek_Sensors.ConfigurationBSensorThreadFactory;

/**
 * Created by ArchyWin on 8/20/2015.
 */
public class ConfigurationBSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.configurationB.prov.IManager configurationB;
    private unicamp.buscame.configurationB.prov.IConfigurationManager configurationBIConf;

    @Override public void execute() {
/*        configurationB = unicamp.buscame.configurationB.impl.ComponentFactory.createInstance();
        configurationBIConf =
                (unicamp.buscame.configurationB.prov.IConfigurationManager) configurationB.getProvidedInterface(IConfigurationManagerTag);
*/
        ConfigurationBSensorThread sensorThread =ConfigurationBSensorThreadFactory.createInstance();
        if(!sensorThread.isAlive() && !ConfigurationBSensorThreadFactory.wasUsed()){
            ConfigurationBSensorThreadFactory.used();
            Log.d("Buscame","Configuration B "+sensorThread.getState().toString());
            sensorThread.start();
        }

    }
}
