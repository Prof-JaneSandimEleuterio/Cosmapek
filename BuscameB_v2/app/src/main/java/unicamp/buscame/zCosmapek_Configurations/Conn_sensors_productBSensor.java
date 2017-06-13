package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_sensors_productBSensor implements IExecution,IInterfaceTags {
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensISens;

    private unicamp.buscame.conn_sensors_productBSensor.prov.IManager sensors_productBSensor;
    private unicamp.buscame.productBSensor.prov.IManager productBSensor;
    @Override
    public synchronized void execute() {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        sensors_productBSensor = unicamp.buscame.conn_sensors_productBSensor.impl.ComponentFactory.createInstance();
        sensors_productBSensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        productBSensor = unicamp.buscame.productBSensor.impl.ComponentFactory.createInstance();
        productBSensor.setRequiredInterface(ISensorUpdaterTag,
                sensors_productBSensor.getProvidedInterface(ISensorUpdaterTag));
    }
}
