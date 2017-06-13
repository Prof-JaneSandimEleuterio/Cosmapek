package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_sensors_configurationBSensor implements IExecution,IInterfaceTags {
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensISens;

    private unicamp.buscame.conn_sensors_configurationBSensor.prov.IManager sensors_configurationBSensor;
    private unicamp.buscame.configurationBSensor.prov.IManager configurationBSensor;
    @Override
    public synchronized void execute() {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        sensors_configurationBSensor = unicamp.buscame.conn_sensors_configurationBSensor.impl.ComponentFactory.createInstance();
        sensors_configurationBSensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        configurationBSensor = unicamp.buscame.configurationBSensor.impl.ComponentFactory.createInstance();
        configurationBSensor.setRequiredInterface(ISensorUpdaterTag,
                sensors_configurationBSensor.getProvidedInterface(ISensorUpdaterTag));
    }
}
