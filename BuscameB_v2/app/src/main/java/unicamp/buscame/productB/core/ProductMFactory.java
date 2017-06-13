package unicamp.buscame.productB.core;

import unicamp.buscame.productB.core.*;
import unicamp.buscame.productB.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ProductMFactory {
    private static unicamp.buscame.productB.core.ProductM productM = null;

    public static synchronized unicamp.buscame.productB.core.ProductM createInstance(IManager manager) {
        if (productM == null)
            productM = new unicamp.buscame.productB.core.ProductM(manager);
        return productM;
    }
}
