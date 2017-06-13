package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class ProductB implements IExecution,IInterfaceTags {
    private unicamp.buscame.productB.prov.IManager productB;
    private unicamp.buscame.productB.prov.IProductManager productBIProd;
    @Override
    public void execute() {
/*        productB = unicamp.buscame.productB.impl.ComponentFactory.createInstance();
        productBIProd =
                (unicamp.buscame.productB.prov.IProductManager) productB.getProvidedInterface(IProductManagerTag);
*/    }
}
