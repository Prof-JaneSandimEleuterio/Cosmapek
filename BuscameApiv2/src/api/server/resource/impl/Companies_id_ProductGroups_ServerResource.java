package api.server.resource.impl;

import api.server.representation.CompanyProductGroup;
import api.server.representation.CompanyProductGroupList;
import api.server.resource.prov.Companies_id_ProductGroups_Resource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Companies_id_ProductGroups_ServerResource extends AbstractServerResource implements
        Companies_id_ProductGroups_Resource, DBConfiguration {
    @Override public CompanyProductGroupList getCompanyProductGroups() throws Exception {
        return null;
    }

    @Override public void removeAllCompanyProductGroups() throws Exception {

    }

    @Override public CompanyProductGroup addACompanyProductGroup(CompanyProductGroup bean)
        throws Exception {
        return null;
    }
}
