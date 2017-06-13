package main;

import api.ApiApplication;
import com.orientechnologies.orient.client.remote.OServerAdmin;
import db.main.FillDataBase_E;
import org.restlet.Component;
import org.restlet.data.Protocol;

import java.io.IOException;

public class Main_E {

    public static void main(String[] args) {
        //IMPORTANT Before to run this script you have to configure the Database that the APi is going to use.
        //READ the above before you execute this script.
        //public static String remoteServer="remote:localhost/ApiBuscame_E"; in DBConfiguration
        try {
            OServerAdmin serverAdmin = new OServerAdmin("remote:localhost");
            serverAdmin.connect("root", "cupecupe");
            //object
            serverAdmin.createDatabase("ApiBuscame_E", "document", "plocal");
            serverAdmin.close();

            // create initial Data
            FillDataBase_E abc=new FillDataBase_E();
            abc.insertSetElements();
            Component c = new Component();
            c.getServers().add(Protocol.HTTP, 9999);
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
