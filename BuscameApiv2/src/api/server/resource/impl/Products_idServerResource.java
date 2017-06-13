package api.server.resource.impl;

import api.server.representation.CompanyProduct;
import api.server.resource.prov.Products_idResource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Products_idServerResource extends AbstractServerResource implements
    Products_idResource, DBConfiguration {

    @Override public CompanyProduct getAProduct() throws Exception {
        return null;
    }

    @Override public CompanyProduct updateAProduct(CompanyProduct bean) throws Exception {
        return null;
    }

    @Override public void removeAProduct() throws Exception {

    }
}
