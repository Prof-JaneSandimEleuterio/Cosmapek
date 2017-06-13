package api.server.resource.impl;

import api.server.representation.CompanyProductList;
import api.server.resource.prov.ProductsResource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class ProductsServerResource extends AbstractServerResource implements ProductsResource, DBConfiguration {

    @Override public CompanyProductList getAProductList() throws Exception {
        return null;
    }
}
