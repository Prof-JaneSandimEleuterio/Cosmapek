package unicamp.buscame.ui.core.act.free;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import unicamp.buscame.R;
import unicamp.buscame.ui.impl.ComponentFactory;
import unicamp.buscame.ui.prov.IManager;
import unicamp.buscame.ui.req.IClientManager;
import unicamp.buscame.ui.req.ICompanyManager;

public class FreeLocalization extends Activity implements OnMapReadyCallback  {
    private IManager managerUi;
    private ICompanyManager companyManager;
    private IClientManager clientManager;
    private GoogleMap manageMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_localization);

        this.managerUi= ComponentFactory.createInstance();
        this.companyManager =
                (ICompanyManager) this.managerUi.getRequiredInterface("ICompanyManager");
        this.clientManager= (IClientManager) this.managerUi.getRequiredInterface("IClientManager");

        // Initial Map
        try {

            if (manageMap == null) {
                MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.free_map);
                manageMap = mapFragment.getMap();
                mapFragment.getMapAsync(this);
                manageMap = mapFragment.getMap();
                manageMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(LatLng latLng) {
                        clientManager.setDefaultLocalization(latLng.latitude, latLng.longitude);
                        startActivity(new Intent(getApplicationContext(), FreeResult.class));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_free_localization, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //***********************************************************

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LocationManager locationManager;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                0, 0, new LocationListenerGps() );
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                0, 0, new LocationListenerNetwork());

        Location res=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Double longitude =-33.867;
        Double latitude =151.206;
        if (res == null) {
        }else{
            longitude=res.getLongitude();
            latitude=res.getLatitude();
        }



        LatLng yourLocation = new LatLng(latitude,longitude );

        googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(yourLocation, 13));


        googleMap.addMarker(new MarkerOptions()
                .title("Your location")
                .snippet("Move this location to another.")
                .position(yourLocation));

    }
    public class LocationListenerGps implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
    public class LocationListenerNetwork implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
