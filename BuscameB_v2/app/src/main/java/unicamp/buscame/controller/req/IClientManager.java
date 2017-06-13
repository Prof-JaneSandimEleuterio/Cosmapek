package unicamp.buscame.controller.req;

import unicamp.buscame.util.representation.ClientLocation;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public interface IClientManager {
    boolean hasDefaultLocation();

    void setDefaultLocalization();//my current location for default

    void setDefaultLocalization(double longitude, double latitude);// set location to search

    ClientLocation getDefaultLocalization(); // get the location to search
}
