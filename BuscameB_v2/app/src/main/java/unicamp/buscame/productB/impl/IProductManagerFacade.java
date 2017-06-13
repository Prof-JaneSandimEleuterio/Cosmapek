package unicamp.buscame.productB.impl;

import unicamp.buscame.productB.core.ProductM;
import unicamp.buscame.productB.core.ProductMFactory;
import unicamp.buscame.productB.impl.*;
import unicamp.buscame.productB.prov.IProductManager;
import unicamp.buscame.productB.prov.IManager;
import unicamp.buscame.util.representation.CompanyProductList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IProductManagerFacade implements unicamp.buscame.productB.impl.IInterfaceTags, IProductManager {
    private IManager manager = null;
    private ProductM productM;

    IProductManagerFacade(IManager manager) {
        this.manager = manager;
        this.productM = ProductMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized CompanyProductList getCompanyProductList(String companyId) {
        return productM.getCompanyProductList(companyId);
    }
}
