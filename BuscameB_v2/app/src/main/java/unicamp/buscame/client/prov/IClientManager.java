package unicamp.buscame.client.prov;

import unicamp.buscame.util.representation.ClientLocation;

public interface IClientManager {
    boolean hasDefaultLocation();

    void setDefaultLocalization();//my current location for default

    void setDefaultLocalization(double longitude, double latitude);// set location to search

    ClientLocation getDefaultLocalization(); // get the location to search

}
