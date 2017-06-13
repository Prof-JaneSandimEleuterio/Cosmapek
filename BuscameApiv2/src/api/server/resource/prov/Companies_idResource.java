package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Companies_idResource {
    @Get
    api.server.representation.Company getACompany() throws Exception;

    @Put
    api.server.representation.Company updateACompany(api.server.representation.Company bean) throws Exception;

    @Delete
    void removeACompany() throws Exception;
}
