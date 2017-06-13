package api.server.resource.impl;

import api.server.representation.CompanyProductList;
import api.server.resource.prov.Products_Resource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Products_ServerResource extends AbstractServerResource implements Products_Resource, DBConfiguration {

    @Override public CompanyProductList getAllProducts() throws Exception {
        return null;
    }

    @Override public void removeAllProducts() throws Exception {

    }
}
