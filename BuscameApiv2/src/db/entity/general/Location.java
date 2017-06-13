package db.entity.general;

import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by Junior Cupe on 8/22/2015.
 */
public class Location {
    @Id
    private Object idObject;

    @Version
    private Object version;
    private double longitude;
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
