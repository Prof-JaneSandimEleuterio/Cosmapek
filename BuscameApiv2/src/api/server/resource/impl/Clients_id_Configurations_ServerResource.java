package api.server.resource.impl;

import api.server.representation.ClientConfigurationList;
import api.server.resource.prov.Clients_id_Configurations_Resource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Clients_id_Configurations_ServerResource extends AbstractServerResource implements
        Clients_id_Configurations_Resource, DBConfiguration {
    @Override public ClientConfigurationList getClientConfigurations() throws Exception {
        return null;
    }

    @Override public void removeAllClientConfigurations() throws Exception {

    }
}
