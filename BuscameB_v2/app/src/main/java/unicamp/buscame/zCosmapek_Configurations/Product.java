package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Product implements IExecution,IInterfaceTags {
    private unicamp.buscame.product.prov.IManager product;
    private unicamp.buscame.product.prov.IProductManager productIProd;

    @Override
    public void execute() {
/*        product = unicamp.buscame.product.impl.ComponentFactory.createInstance();
        productIProd =
                (unicamp.buscame.product.prov.IProductManager) product.getProvidedInterface(IProductManagerTag);
*/    }
}
