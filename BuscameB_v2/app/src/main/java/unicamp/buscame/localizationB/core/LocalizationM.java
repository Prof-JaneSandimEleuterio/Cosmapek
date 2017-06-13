package unicamp.buscame.localizationB.core;

import com.google.gson.Gson;

import org.restlet.Client;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.engine.connector.HttpClientHelper;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;

import unicamp.buscame.localizationB.prov.IManager;
import unicamp.buscame.util.representation.CompanyList;

/**
 * @author Junior Cupe Casquina
 */
public class LocalizationM {
    private IManager manager;


    public LocalizationM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
    }

    public synchronized CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies) {
        getManagers();
        /*Engine.getInstance().getRegisteredClients().clear();
        Engine.getInstance().getRegisteredClients()
                .add(new HttpClientHelper(new Client(Protocol.HTTP)));
        Engine.getInstance().getRegisteredConverters()
                .add(new JacksonConverter());*/
        //ClientResource cr = new ClientResource("http://192.168.0.104:9999/v1/companies");
        ClientResource cr = new ClientResource("http://177.220.84.151:9999/v1/companies");
        cr.getReference().addQueryParameter("longitude",longitude.toString());
        cr.getReference().addQueryParameter("latitude",latitude.toString());
        cr.getReference().addQueryParameter("num", Integer.toString(numCompanies) );
        cr.setRequestEntityBuffering(true);
        Representation clientRepresentation = cr.get(MediaType.APPLICATION_JSON);

        String jsonT= null;
        try {
            jsonT = clientRepresentation.getText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();

        CompanyList companyList = (CompanyList) gson.fromJson(jsonT, CompanyList.class);

        return companyList;
    }
}
