package unicamp.buscame.product.impl;

import unicamp.buscame.product.core.ProductM;
import unicamp.buscame.product.core.ProductMFactory;
import unicamp.buscame.product.prov.IProductManager;
import unicamp.buscame.product.prov.IManager;
import unicamp.buscame.util.representation.CompanyProductList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IProductManagerFacade implements IInterfaceTags, IProductManager {
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
