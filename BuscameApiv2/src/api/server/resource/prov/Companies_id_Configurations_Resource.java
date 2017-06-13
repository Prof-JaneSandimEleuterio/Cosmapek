package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Companies_id_Configurations_Resource {
    @Get
    api.server.representation.CompanyConfigurationList getCompanyConfigurations() throws Exception;
    //restrict to 1 configuration

    @Delete
    void removeAllCompanyConfigurations() throws Exception;
}
