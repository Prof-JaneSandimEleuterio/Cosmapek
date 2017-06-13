package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_productC_productCSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.productC.prov.IManager productC;
    private unicamp.buscame.productC.prov.IProductManager productCIProd;

    private unicamp.buscame.conn_productC_productCSensor.prov.IManager productC_productCSensor;
    private unicamp.buscame.productCSensor.prov.IManager productCSensor;
    @Override
    public synchronized void execute() {
        productC = unicamp.buscame.productC.impl.ComponentFactory.createInstance();
        productCIProd =
                (unicamp.buscame.productC.prov.IProductManager) productC.getProvidedInterface(IProductManagerTag);
        productC_productCSensor =unicamp.buscame.conn_productC_productCSensor.impl.ComponentFactory.createInstance();
        productC_productCSensor.setRequiredInterface(IProductManagerTag, productCIProd);

        productCSensor = unicamp.buscame.productCSensor.impl.ComponentFactory.createInstance();
        productCSensor.setRequiredInterface(IProductManagerTag,
                productC_productCSensor.getProvidedInterface(IProductManagerTag));
    }
}
