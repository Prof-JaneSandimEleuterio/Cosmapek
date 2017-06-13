package api.server.resource.impl;

import api.server.representation.Company;
import api.server.representation.CompanyList;
import api.server.resource.prov.Companies_Resource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Companies_ServerResource extends AbstractServerResource implements Companies_Resource, DBConfiguration {

    @Override public CompanyList getAllCompanies() throws Exception {
        return null;
    }

    @Override public void removeAllCompanies() throws Exception {

    }

    @Override public Company addACompany(Company bean) throws Exception {
        return null;
    }
}
