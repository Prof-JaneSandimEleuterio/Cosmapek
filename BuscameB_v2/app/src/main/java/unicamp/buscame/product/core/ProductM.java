package unicamp.buscame.product.core;

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

import unicamp.buscame.product.prov.IManager;
import unicamp.buscame.util.representation.CompanyProductList;

/**
 * @author Junior Cupe Casquina
 */
public class ProductM {
    private IManager manager;

    public ProductM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
    }

    public synchronized CompanyProductList getCompanyProductList(String companyId) {
        getManagers();
        /*Engine.getInstance().getRegisteredClients().clear();
        Engine.getInstance().getRegisteredClients()
                .add(new HttpClientHelper(new Client(Protocol.HTTP)));
        Engine.getInstance().getRegisteredConverters()
                .add(new JacksonConverter());*/

        //ClientResource cr = new ClientResource("http://192.168.0.104:1723/v1/companies/"+companyId+"/products/");
        ClientResource cr = new ClientResource("http://177.220.84.151:1723/v1/companies/"+companyId+"/products/");
        Representation clientRepresentation = cr.get(MediaType.APPLICATION_JSON);
        String jsonT= null;
        try {
            jsonT = clientRepresentation.getText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        CompanyProductList productList = (CompanyProductList) gson.fromJson(jsonT, CompanyProductList.class);
        return productList;

    }
}
