package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_sensors_localizationCSensor implements IExecution,IInterfaceTags {

    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensISens;
    private unicamp.buscame.conn_sensors_localizationCSensor.prov.IManager sensors_localizationCSensor;
    private unicamp.buscame.localizationCSensor.prov.IManager localizationCSensor;
    @Override
    public synchronized void execute() {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        sensors_localizationCSensor = unicamp.buscame.conn_sensors_localizationCSensor.impl.ComponentFactory.createInstance();
        sensors_localizationCSensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        localizationCSensor = unicamp.buscame.localizationCSensor.impl.ComponentFactory.createInstance();
        localizationCSensor.setRequiredInterface(ISensorUpdaterTag,
                sensors_localizationCSensor.getProvidedInterface(ISensorUpdaterTag));
    }
}
