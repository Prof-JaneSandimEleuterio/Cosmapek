package api.server.resource.prov;

import org.restlet.resource.Get;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface ClientsResource {
    @Get
    api.server.representation.ClientList getAClientList() throws Exception;
    //parameters: localization longitude,latitude
    //parameters: Number
}
