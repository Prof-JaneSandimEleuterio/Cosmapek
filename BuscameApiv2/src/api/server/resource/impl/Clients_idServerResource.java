package api.server.resource.impl;

import api.server.representation.Client;
import api.server.resource.prov.Clients_idResource;
import db.main.DBConfiguration;
import org.restlet.data.Reference;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Clients_idServerResource extends AbstractServerResource implements Clients_idResource, DBConfiguration {
    @Override public Client getAClient() throws Exception {

        System.out.println("hola ingrese");
        String clientidPathVariable = Reference.decode(getAttribute("clientId"));
        api.server.representation.Client rest= new Client();
        /*rest.setName("S");
        rest.setAge(10);
        rest.setId(clientidPathVariable);
        rest.setLocation("idLocalization");
        rest.setConfiguration("idConfiguration");*/
        return rest;
    }


    @Override public Client updateAClient(Client bean) throws Exception {
        return null;
    }

    @Override public void removeAClient() throws Exception {

    }
}
