package unicamp.buscame.configuration.core;

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

import unicamp.buscame.configuration.prov.IManager;
import unicamp.buscame.util.representation.CompanyOperationHourList;

/**
 * @author Junior Cupe Casquina
 */
public class ConfigurationM {
    private IManager manager;

    public ConfigurationM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
    }

    public synchronized CompanyOperationHourList getOperationHourList(String companyId) {
        getManagers();
        /*Engine.getInstance().getRegisteredClients().clear();
        Engine.getInstance().getRegisteredClients()
                .add(new HttpClientHelper(new Client(Protocol.HTTP)));
        Engine.getInstance().getRegisteredConverters()
                .add(new JacksonConverter());*/
        //http://52.10.127.166:9111/v1/companies/
        //ClientResource cr = new ClientResource("http://192.168.0.104:5222/v1/companies/"+companyId+"/operationHour/");
        ClientResource cr = new ClientResource("http://177.220.84.151:5222/v1/companies/"+companyId+"/operationHour/");

        Representation clientRepresentation = cr.get(MediaType.APPLICATION_JSON);
        String jsonT= null;
        try {
            jsonT = clientRepresentation.getText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        CompanyOperationHourList companyOperationHourList = (CompanyOperationHourList) gson.fromJson(jsonT, CompanyOperationHourList.class);

        return companyOperationHourList;

    }
}
