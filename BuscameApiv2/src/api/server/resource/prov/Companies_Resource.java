package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Companies_Resource {
    @Get
    api.server.representation.CompanyList getAllCompanies() throws Exception;

    @Delete
    void removeAllCompanies() throws Exception;

    @Post
    api.server.representation.Company addACompany(api.server.representation.Company bean) throws Exception;
}
