package unicamp.buscame.conn_productB_productBSensor.impl;

import unicamp.buscame.conn_productB_productBSensor.prov.IManager;
import unicamp.buscame.util.representation.CompanyProductList;

class Adapter
    implements unicamp.buscame.productBSensor.req.IProductManager, unicamp.buscame.conn_productB_productBSensor.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized CompanyProductList getCompanyProductList(String companyId) {
        unicamp.buscame.productB.prov.IProductManager compProduct =
                (unicamp.buscame.productB.prov.IProductManager) this.manager.getRequiredInterface(IProductManagerTag);
        return compProduct.getCompanyProductList(companyId);
    }
}
