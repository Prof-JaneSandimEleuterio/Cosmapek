package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_productC_company implements IExecution,IInterfaceTags {
    private unicamp.buscame.productC.prov.IManager productC;
    private unicamp.buscame.productC.prov.IProductManager productCIProd;

    private unicamp.buscame.conn_productC_company.prov.IManager productC_company;
    private unicamp.buscame.company.prov.IManager company;
    @Override
    public synchronized void execute() {
        productC = unicamp.buscame.productC.impl.ComponentFactory.createInstance();
        productCIProd =
                (unicamp.buscame.productC.prov.IProductManager) productC.getProvidedInterface(IProductManagerTag);
        productC_company = unicamp.buscame.conn_productC_company.impl.ComponentFactory.createInstance();
        productC_company.setRequiredInterface(IProductManagerTag, productCIProd);

        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        company.setRequiredInterface(IProductManagerTag,
                productC_company.getProvidedInterface(IProductManagerTag));
    }
}
