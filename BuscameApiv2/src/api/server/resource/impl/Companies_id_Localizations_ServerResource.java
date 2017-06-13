package api.server.resource.impl;

import api.server.representation.CompanyLocation;
import api.server.representation.CompanyLocationList;
import api.server.resource.prov.Companies_id_Localizations_Resource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Companies_id_Localizations_ServerResource extends AbstractServerResource implements
        Companies_id_Localizations_Resource, DBConfiguration {
    @Override public CompanyLocationList getCompanyLocations() throws Exception {
        return null;
    }

    @Override public void removeAllCompanyLocations() throws Exception {

    }

    @Override public CompanyLocation addACompanyLocation(CompanyLocation bean) throws Exception {
        return null;
    }
}
