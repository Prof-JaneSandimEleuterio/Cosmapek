package api.server.resource.impl;

import api.server.representation.Company;
import api.server.resource.prov.Companies_idResource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Companies_idServerResource extends AbstractServerResource implements
        Companies_idResource, DBConfiguration {
    @Override public Company getACompany() throws Exception {
        return null;
    }

    @Override public Company updateACompany(Company bean) throws Exception {
        return null;
    }

    @Override public void removeACompany() throws Exception {

    }
}
