package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_sensors_productCSensor implements IExecution,IInterfaceTags {
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensISens;

    private unicamp.buscame.conn_sensors_productCSensor.prov.IManager sensors_productCSensor;
    private unicamp.buscame.productCSensor.prov.IManager productCSensor;
    @Override
    public synchronized void execute() {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        sensors_productCSensor = unicamp.buscame.conn_sensors_productCSensor.impl.ComponentFactory.createInstance();
        sensors_productCSensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        productCSensor = unicamp.buscame.productCSensor.impl.ComponentFactory.createInstance();
        productCSensor.setRequiredInterface(ISensorUpdaterTag,
                sensors_productCSensor.getProvidedInterface(ISensorUpdaterTag));
    }
}
