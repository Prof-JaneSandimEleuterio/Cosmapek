package api.server.representation;

import java.io.Serializable;

public class ClientLocation implements Serializable {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private String id;
    private String longitude;
    private String latitude;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

}
