package api.server.resource.impl;

import api.server.representation.CompanyProductGroup;
import api.server.resource.prov.Companies_id_ProductGroups_idResource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Companies_id_ProductGroups_idServerResource extends AbstractServerResource implements
        Companies_id_ProductGroups_idResource, DBConfiguration {
    @Override public CompanyProductGroup getACompanyProductGroup() throws Exception {
        return null;
    }

    @Override public CompanyProductGroup updateACompanyProductGroup(CompanyProductGroup bean)
        throws Exception {
        return null;
    }

    @Override public void removeACompanyProductGroup() throws Exception {

    }
}
