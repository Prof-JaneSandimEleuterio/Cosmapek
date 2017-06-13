package unicamp.buscame.client.core;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import unicamp.buscame.client.prov.IManager;
import unicamp.buscame.util.ActivityController;
import unicamp.buscame.util.ActivityControllerFactory;
import unicamp.buscame.util.representation.ClientLocation;

/**
 * @author Junior Cupe Casquina
 */
public class ClientM {
    private IManager manager;
    private ClientLocalization clientLocalization;
    private ActivityController activityController;
    private LocationManager locationManager;
    private LocationListenerGps locationListenerGps;
    private LocationListenerNetwork locationListenerNetwork;
    private boolean hasDefaultLocation;

    public ClientM(IManager manager) {
        this.manager = manager;
        this.clientLocalization = ClientLocalizationFactory.createInstance();
        this.activityController = ActivityControllerFactory.createInstance();
        this.hasDefaultLocation = false;
    }

    private void getManagers() {
    }

    synchronized public void setDefaultLocalization() {
        getManagers();

        locationListenerGps = new LocationListenerGps();
        locationListenerNetwork = new LocationListenerNetwork();

        Activity act=activityController.getMainActivity();
        locationManager = (LocationManager) act.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                    0, 0, locationListenerGps);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    0, 0, locationListenerNetwork);

        Location res=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if(res==null){
            clientLocalization.setLongitude(-10.0);
            clientLocalization.setLatitude(-20.0);
        }else{
            clientLocalization.setLongitude(res.getLongitude());
            clientLocalization.setLatitude(res.getLatitude());
        }
        hasDefaultLocation = true;
    }

    synchronized public void setDefaultLocalization(double longitude, double latitude) {
        getManagers();
        clientLocalization.setLongitude(longitude);
        clientLocalization.setLatitude(latitude);
        hasDefaultLocation = true;
    }

    synchronized public ClientLocation getDefaultLocalization() {
        getManagers();
        ClientLocation res=new ClientLocation();
        res.setId("default");
        res.setLatitude(Double.toString(clientLocalization.getLatitude()));
        res.setLongitude(Double.toString(clientLocalization.getLongitude()));
        return res;
    }

    synchronized public boolean hasDefaultLocation() {
        return hasDefaultLocation;
    }
}
