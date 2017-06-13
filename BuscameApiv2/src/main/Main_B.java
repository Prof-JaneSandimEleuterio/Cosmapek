package main;

import api.ApiApplication;
import com.orientechnologies.orient.client.remote.OServerAdmin;
import db.main.FillDataBase_B;
import org.restlet.Component;
import org.restlet.data.Protocol;

import java.io.IOException;

public class Main_B {

    public static void main(String[] args) {
        //IMPORTANT Before to run this script you have to configure the Database that the APi is going to use.
        //READ the above before you execute this script.
        //public static String remoteServer="remote:localhost/ApiBuscame_B"; in DBConfiguration
        try {
            OServerAdmin serverAdmin = new OServerAdmin("remote:localhost");
            serverAdmin.connect("root", "cupecupe");
            //object
            serverAdmin.createDatabase("ApiBuscame_B", "document", "plocal");
            serverAdmin.close();

            // create initial Data
            FillDataBase_B abc=new FillDataBase_B();
            abc.insertSetElements();
            Component c = new Component();
            c.getServers().add(Protocol.HTTP, 10000);
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
