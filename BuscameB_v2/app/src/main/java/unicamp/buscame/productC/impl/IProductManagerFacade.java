package unicamp.buscame.productC.impl;

import unicamp.buscame.productC.core.ProductM;
import unicamp.buscame.productC.core.ProductMFactory;
import unicamp.buscame.productC.impl.*;
import unicamp.buscame.productC.prov.IProductManager;
import unicamp.buscame.productC.prov.IManager;
import unicamp.buscame.util.representation.CompanyProductList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IProductManagerFacade implements unicamp.buscame.productC.impl.IInterfaceTags, IProductManager {
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
