package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Clients_Resource {
    @Get
    api.server.representation.ClientList getAllClients() throws Exception;

    @Delete
    void removeAllClients() throws Exception;

    @Post
    api.server.representation.Client addAClient(api.server.representation.Client bean) throws Exception;
}
