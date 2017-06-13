package api.server.resource.impl;

import api.server.representation.ClientList;
import api.server.resource.prov.ClientsResource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class ClientsServerResource extends AbstractServerResource implements ClientsResource, DBConfiguration {

    @Override public ClientList getAClientList() throws Exception {
        return null;
    }
}
