package unicamp.buscame.conn_product_company.impl;

import unicamp.buscame.conn_product_company.prov.IManager;
import unicamp.buscame.util.representation.CompanyProductList;

class Adapter
    implements unicamp.buscame.company.req.IProductManager, unicamp.buscame.conn_product_company.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized CompanyProductList getCompanyProductList(String companyId) {
        unicamp.buscame.product.prov.IProductManager compProduct =
                (unicamp.buscame.product.prov.IProductManager) this.manager.getRequiredInterface(IProductManagerTag);
        return compProduct.getCompanyProductList(companyId);
    }
}
