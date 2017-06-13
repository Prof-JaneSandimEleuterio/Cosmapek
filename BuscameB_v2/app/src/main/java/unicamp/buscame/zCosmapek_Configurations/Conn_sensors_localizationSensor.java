package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_sensors_localizationSensor implements IExecution,IInterfaceTags {
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensISens;

    private unicamp.buscame.conn_sensors_localizationSensor.prov.IManager sensors_localizationSensor;
    private unicamp.buscame.localizationSensor.prov.IManager localizationSensor;
    @Override
    public synchronized void execute() {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        sensors_localizationSensor = unicamp.buscame.conn_sensors_localizationSensor.impl.ComponentFactory.createInstance();
        sensors_localizationSensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        localizationSensor = unicamp.buscame.localizationSensor.impl.ComponentFactory.createInstance();
        localizationSensor.setRequiredInterface(ISensorUpdaterTag,
                sensors_localizationSensor.getProvidedInterface(ISensorUpdaterTag));
    }
}
