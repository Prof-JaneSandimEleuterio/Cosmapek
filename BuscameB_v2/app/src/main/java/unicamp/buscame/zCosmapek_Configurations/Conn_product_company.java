package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_product_company implements IExecution,IInterfaceTags {
    private unicamp.buscame.product.prov.IManager product;
    private unicamp.buscame.product.prov.IProductManager productIProd;

    private unicamp.buscame.conn_product_company.prov.IManager product_company;
    private unicamp.buscame.company.prov.IManager company;
    @Override
    public synchronized void execute() {
        product = unicamp.buscame.product.impl.ComponentFactory.createInstance();
        productIProd =
                (unicamp.buscame.product.prov.IProductManager) product.getProvidedInterface(IProductManagerTag);

        product_company = unicamp.buscame.conn_product_company.impl.ComponentFactory.createInstance();
        product_company.setRequiredInterface(IProductManagerTag, productIProd);

        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        company.setRequiredInterface(IProductManagerTag,
                product_company.getProvidedInterface(IProductManagerTag));
    }
}
