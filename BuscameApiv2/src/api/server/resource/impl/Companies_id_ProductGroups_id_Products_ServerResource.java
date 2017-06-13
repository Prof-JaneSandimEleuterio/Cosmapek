package api.server.resource.impl;

import api.server.representation.CompanyProduct;
import api.server.representation.CompanyProductList;
import api.server.resource.prov.Companies_id_ProductGroups_id_Products_Resource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Companies_id_ProductGroups_id_Products_ServerResource extends AbstractServerResource implements
    Companies_id_ProductGroups_id_Products_Resource, DBConfiguration {
    @Override public CompanyProductList getCompanyProductGroupsProducts() throws Exception {
        return null;
    }

    @Override public void removeAllCompanyProductGroupsProducts() throws Exception {

    }

    @Override public CompanyProduct addACompanyProductGroupProduct(CompanyProduct bean)
        throws Exception {
        return null;
    }
}
