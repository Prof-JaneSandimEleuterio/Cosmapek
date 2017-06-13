package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_productB_company implements IExecution,IInterfaceTags {
    private unicamp.buscame.productB.prov.IManager productB;
    private unicamp.buscame.productB.prov.IProductManager productBIProd;

    private unicamp.buscame.conn_productB_company.prov.IManager productB_company;
    private unicamp.buscame.company.prov.IManager company;
    @Override
    public synchronized void execute() {
        productB = unicamp.buscame.productB.impl.ComponentFactory.createInstance();
        productBIProd =
                (unicamp.buscame.productB.prov.IProductManager) productB.getProvidedInterface(IProductManagerTag);

        productB_company = unicamp.buscame.conn_productB_company.impl.ComponentFactory.createInstance();
        productB_company.setRequiredInterface(IProductManagerTag, productBIProd);

        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        company.setRequiredInterface(IProductManagerTag,
                productB_company.getProvidedInterface(IProductManagerTag));

    }
}
