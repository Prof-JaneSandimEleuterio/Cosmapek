package api.server.resource.impl;

import api.server.representation.CompanyConfigurationList;
import api.server.resource.prov.Companies_id_Configurations_Resource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Companies_id_Configurations_ServerResource extends AbstractServerResource implements
    Companies_id_Configurations_Resource, DBConfiguration {
    @Override public CompanyConfigurationList getCompanyConfigurations() throws Exception {
        return null;
    }

    @Override public void removeAllCompanyConfigurations() throws Exception {

    }
}
