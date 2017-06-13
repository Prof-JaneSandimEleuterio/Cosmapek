package unicamp.buscame.zCosmapek_Configurations;

import android.util.Log;

import mapekcosmos.interfaces.IExecution;
import unicamp.buscame.zCosmapek_Sensors.LocalizationCSensorThread;
import unicamp.buscame.zCosmapek_Sensors.LocalizationCSensorThreadFactory;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class LocalizationCSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.localizationCSensor.prov.IManager localizationCSensor;
    private unicamp.buscame.localizationCSensor.prov.ISensorUpdaterManager localizationCSensorISenUp;
    @Override
    public void execute() {
/*        localizationCSensor = unicamp.buscame.localizationCSensor.impl.ComponentFactory.createInstance();
        localizationCSensorISenUp =
                (unicamp.buscame.localizationCSensor.prov.ISensorUpdaterManager) localizationCSensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        LocalizationCSensorThread sensorThread = LocalizationCSensorThreadFactory.createInstance();
       // sensorThread.start();
        if(!sensorThread.isAlive() && !LocalizationCSensorThreadFactory.wasUsed()){
            LocalizationCSensorThreadFactory.used();
           Log.d("Buscame", "Localization C "+sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}
