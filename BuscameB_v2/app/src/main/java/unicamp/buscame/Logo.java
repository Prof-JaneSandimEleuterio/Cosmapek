package unicamp.buscame;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;

import org.restlet.Client;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.engine.connector.HttpClientHelper;
import org.restlet.ext.jackson.JacksonConverter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import unicamp.buscame.util.ActivityController;
import unicamp.buscame.util.ActivityControllerFactory;

public class Logo extends Activity implements IInterfaceTags {

    private unicamp.buscame.controller.prov.IManager controller;
    private unicamp.buscame.controller.prov.IControllerManager controllerIContr;

    private GestureDetector detector;
    private MapeKCosmosThread backgroundCosmos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//remove title
        setContentView(R.layout.activity_logo);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //to not use the asyn
        StrictMode.setThreadPolicy(policy);

        ActivityController mag = ActivityControllerFactory.createInstance();
        mag.setMainActivity(this);
        mag.setMainPackage(this.getPackageName());

        detector = new GestureDetector(this, new SplashListener());



    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class SplashListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            //configurations
            String jarPath = "unicamp.buscame.zCosmapek_Configurations";
            File sdcard = Environment.getExternalStorageDirectory();
            File sdcard_config= new File(sdcard,"config.xml");
            File sdcard_variability= new File(sdcard,"variability.xml");
            //BackGround MapeK
            backgroundCosmos=MapeKCosmosThreadFactory.createInstance(sdcard_variability.getPath(),sdcard_config.getPath(),jarPath);
            controller = unicamp.buscame.controller.impl.ComponentFactory.createInstance();
            controllerIContr =
                    (unicamp.buscame.controller.prov.IControllerManager) controller.getProvidedInterface(IControllerManagerTag);

            //register client http
            Engine.getInstance().getRegisteredClients().clear();
          /*  Engine.getInstance().getRegisteredClients()
                    .add(new HttpClientHelper(new Client(Protocol.HTTP)));*/
            Engine.getInstance().getRegisteredClients()
                    .add(new HttpClientHelper(null));
            Engine.getInstance().getRegisteredConverters().clear();
            Engine.getInstance().getRegisteredConverters()
                    .add(new JacksonConverter());
//


  //          controllerIContr.createFreeMainUI();

            if(!backgroundCosmos.isAlive() && !MapeKCosmosThreadFactory.wasUsed()){
                MapeKCosmosThreadFactory.used();
                backgroundCosmos.start();
            }
            controllerIContr.createFreeMainUI();
        }
    }
/*
    @Override
    protected void onDestroy() {
        backgroundCosmos.interrupt();
        super.onDestroy();
    }*/
}
