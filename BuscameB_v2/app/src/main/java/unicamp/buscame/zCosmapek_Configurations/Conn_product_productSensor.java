package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_product_productSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.product.prov.IManager product;
    private unicamp.buscame.product.prov.IProductManager productIProd;

    private unicamp.buscame.conn_product_productSensor.prov.IManager product_productSensor;
    private unicamp.buscame.productSensor.prov.IManager productSensor;
    @Override
    public synchronized void execute() {
        product = unicamp.buscame.product.impl.ComponentFactory.createInstance();
        productIProd =
                (unicamp.buscame.product.prov.IProductManager) product.getProvidedInterface(IProductManagerTag);
        product_productSensor =unicamp.buscame.conn_product_productSensor.impl.ComponentFactory.createInstance();
        product_productSensor.setRequiredInterface(IProductManagerTag, productIProd);

        productSensor = unicamp.buscame.productSensor.impl.ComponentFactory.createInstance();
        productSensor.setRequiredInterface(IProductManagerTag,
                product_productSensor.getProvidedInterface(IProductManagerTag));

    }
}
