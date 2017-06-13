package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_sensors_localizationBSensor implements IExecution,IInterfaceTags {
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensISens;

    private unicamp.buscame.conn_sensors_localizationBSensor.prov.IManager sensors_localizationBSensor;
    private unicamp.buscame.localizationBSensor.prov.IManager localizationBSensor;
    @Override
    public synchronized void execute() {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        sensors_localizationBSensor = unicamp.buscame.conn_sensors_localizationBSensor.impl.ComponentFactory.createInstance();
        sensors_localizationBSensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        localizationBSensor = unicamp.buscame.localizationBSensor.impl.ComponentFactory.createInstance();
        localizationBSensor.setRequiredInterface(ISensorUpdaterTag,
                sensors_localizationBSensor.getProvidedInterface(ISensorUpdaterTag));
    }
}

