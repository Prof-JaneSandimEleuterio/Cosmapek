package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Companies_id_ProductGroups_idResource {
    @Get
    api.server.representation.CompanyProductGroup getACompanyProductGroup() throws Exception;

    @Put
    api.server.representation.CompanyProductGroup updateACompanyProductGroup(api.server.representation.CompanyProductGroup bean) throws Exception;

    @Delete
    void removeACompanyProductGroup() throws Exception;
}
