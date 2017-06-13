package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_sensors_configurationSensor implements IExecution,IInterfaceTags {
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensISens;

    private unicamp.buscame.conn_sensors_configurationSensor.prov.IManager sensors_configurationSensor;
    private unicamp.buscame.configurationSensor.prov.IManager configurationSensor;
    @Override
    public synchronized void execute() {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        sensors_configurationSensor = unicamp.buscame.conn_sensors_configurationSensor.impl.ComponentFactory.createInstance();
        sensors_configurationSensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        configurationSensor = unicamp.buscame.configurationSensor.impl.ComponentFactory.createInstance();
        configurationSensor.setRequiredInterface(ISensorUpdaterTag,
                sensors_configurationSensor.getProvidedInterface(ISensorUpdaterTag));
    }
}
