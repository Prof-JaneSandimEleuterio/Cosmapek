package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Companies_id_Localizations_Resource {
    @Get
    api.server.representation.CompanyLocationList getCompanyLocations() throws Exception;

    @Delete
    void removeAllCompanyLocations() throws Exception;

    @Post
    api.server.representation.CompanyLocation addACompanyLocation(api.server.representation.CompanyLocation bean) throws Exception;
}
