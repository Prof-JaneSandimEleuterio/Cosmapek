package unicamp.buscame.productC.core;

import unicamp.buscame.productC.core.*;
import unicamp.buscame.productC.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ProductMFactory {
    private static unicamp.buscame.productC.core.ProductM productM = null;

    public static synchronized unicamp.buscame.productC.core.ProductM createInstance(IManager manager) {
        if (productM == null)
            productM = new unicamp.buscame.productC.core.ProductM(manager);
        return productM;
    }
}
