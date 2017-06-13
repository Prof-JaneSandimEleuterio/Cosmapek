package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_productB_productBSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.productB.prov.IManager productB;
    private unicamp.buscame.productB.prov.IProductManager productBIProd;

    private unicamp.buscame.conn_productB_productBSensor.prov.IManager productB_productBSensor;
    private unicamp.buscame.productBSensor.prov.IManager productBSensor;
    @Override
    public synchronized void execute() {
        productB = unicamp.buscame.productB.impl.ComponentFactory.createInstance();
        productBIProd =
                (unicamp.buscame.productB.prov.IProductManager) productB.getProvidedInterface(IProductManagerTag);

        productB_productBSensor =unicamp.buscame.conn_productB_productBSensor.impl.ComponentFactory.createInstance();
        productB_productBSensor.setRequiredInterface(IProductManagerTag, productBIProd);

        productBSensor = unicamp.buscame.productBSensor.impl.ComponentFactory.createInstance();
        productBSensor.setRequiredInterface(IProductManagerTag,
                productB_productBSensor.getProvidedInterface(IProductManagerTag));

    }
}
