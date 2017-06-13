package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Clients_id_Localizations_Resource {
    @Get
    api.server.representation.ClientLocationList getClientLocations() throws Exception;

    @Delete
    void removeAllClientLocations() throws Exception;

    @Post
    api.server.representation.ClientLocation addAClientLocation(api.server.representation.ClientLocation bean) throws Exception;

}
