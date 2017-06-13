import api.ApiApplication;
import com.orientechnologies.orient.client.remote.OServerAdmin;
import db.main.FillDataBase_A;
import org.restlet.Component;
import org.restlet.data.Protocol;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            OServerAdmin serverAdmin = new OServerAdmin("remote:localhost");
            serverAdmin.connect("root", "cupecupe");
            //object
            serverAdmin.createDatabase("ApiBuscame_A", "document", "plocal");
            serverAdmin.close();

            // create initial Data
            FillDataBase_A abc=new FillDataBase_A();
            abc.insertSetElements();//insert data in the quadtree and the Database
            Component c = new Component();
            c.getServers().add(Protocol.HTTP, 1723);
            c.getDefaultHost().attach("/v1", new ApiApplication());
            try {
                c.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
