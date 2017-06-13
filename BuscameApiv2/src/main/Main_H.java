package main;

import api.ApiApplication;
import com.orientechnologies.orient.client.remote.OServerAdmin;
import db.main.FillDataBase_H;
import org.restlet.Component;
import org.restlet.data.Protocol;

import java.io.IOException;

public class Main_H {

    public static void main(String[] args) {
        //IMPORTANT Before to run this script you have to configure the Database that the APi is going to use.
        //READ the above before you execute this script.
        //public static String remoteServer="remote:localhost/ApiBuscame_H"; in DBConfiguration
        try {
            OServerAdmin serverAdmin = new OServerAdmin("remote:localhost");
            serverAdmin.connect("root", "cupecupe");
            //object
            serverAdmin.createDatabase("ApiBuscame_H", "document", "plocal");
            serverAdmin.close();

            // create initial Data
            FillDataBase_H abc=new FillDataBase_H();
            abc.insertSetElements();
            Component c = new Component();
            c.getServers().add(Protocol.HTTP, 3389);
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
