package api.server.resource.impl;

import api.server.representation.Client;
import api.server.representation.ClientList;
import api.server.resource.prov.Clients_Resource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Clients_ServerResource extends AbstractServerResource implements Clients_Resource, DBConfiguration {

    @Override public ClientList getAllClients() throws Exception {
        return null;
    }

    @Override public void removeAllClients() throws Exception {

    }

    @Override public Client addAClient(Client bean) throws Exception {
        return null;
    }
}
