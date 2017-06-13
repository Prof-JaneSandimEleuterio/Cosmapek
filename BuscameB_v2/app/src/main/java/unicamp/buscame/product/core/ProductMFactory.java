package unicamp.buscame.product.core;

import unicamp.buscame.product.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ProductMFactory {
    private static ProductM productM = null;

    public static synchronized ProductM createInstance(IManager manager) {
        if (productM == null)
            productM = new ProductM(manager);
        return productM;
    }
}
