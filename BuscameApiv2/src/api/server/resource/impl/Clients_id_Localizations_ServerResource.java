package api.server.resource.impl;

import api.server.representation.ClientLocation;
import api.server.representation.ClientLocationList;
import api.server.resource.prov.Clients_id_Localizations_Resource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Clients_id_Localizations_ServerResource extends AbstractServerResource implements
        Clients_id_Localizations_Resource, DBConfiguration {

    @Override public ClientLocationList getClientLocations() throws Exception {
        return null;
    }

    @Override public void removeAllClientLocations() throws Exception {

    }

    @Override public ClientLocation addAClientLocation(ClientLocation bean) throws Exception {
        return null;
    }
}
