package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_sensors_productSensor implements IExecution,IInterfaceTags {
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensISens;

    private unicamp.buscame.conn_sensors_productSensor.prov.IManager sensors_productSensor;
    private unicamp.buscame.productSensor.prov.IManager productSensor;
    @Override
    public synchronized void execute() {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        sensors_productSensor=unicamp.buscame.conn_sensors_productSensor.impl.ComponentFactory.createInstance();
        sensors_productSensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        productSensor = unicamp.buscame.productSensor.impl.ComponentFactory.createInstance();
        productSensor.setRequiredInterface(ISensorUpdaterTag,
                sensors_productSensor.getProvidedInterface(ISensorUpdaterTag));
    }
}
