package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class ProductC implements IExecution,IInterfaceTags {
    private unicamp.buscame.productC.prov.IManager productC;
    private unicamp.buscame.productC.prov.IProductManager productCIProd;
    @Override
    public void execute() {
/*        productC = unicamp.buscame.productC.impl.ComponentFactory.createInstance();
        productCIProd =
                (unicamp.buscame.productC.prov.IProductManager) productC.getProvidedInterface(IProductManagerTag);
*/    }
}
