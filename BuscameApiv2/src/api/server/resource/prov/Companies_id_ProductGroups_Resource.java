package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Companies_id_ProductGroups_Resource {
    @Get
    api.server.representation.CompanyProductGroupList getCompanyProductGroups() throws Exception;

    @Delete
    void removeAllCompanyProductGroups() throws Exception;

    @Post
    api.server.representation.CompanyProductGroup addACompanyProductGroup(api.server.representation.CompanyProductGroup bean) throws Exception;

}
