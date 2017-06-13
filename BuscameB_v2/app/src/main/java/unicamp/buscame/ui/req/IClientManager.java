package unicamp.buscame.ui.req;

import unicamp.buscame.util.representation.ClientLocation;

/**
 * @author ArchyWin on 8/31/2015.
 */
public interface IClientManager {

    boolean hasDefaultLocation();

    void setDefaultLocalization();//my current location for default

    void setDefaultLocalization(double longitude, double latitude);// set location to search

    ClientLocation getDefaultLocalization(); // get the location to search
}
