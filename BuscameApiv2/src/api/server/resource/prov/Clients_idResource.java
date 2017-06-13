package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Clients_idResource {
    @Get
    api.server.representation.Client getAClient() throws Exception;

    @Put
    api.server.representation.Client updateAClient(api.server.representation.Client bean) throws Exception;

    @Delete
    void removeAClient() throws Exception;
}
