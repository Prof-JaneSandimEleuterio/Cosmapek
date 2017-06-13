package mapekcosmos.sensors.prov;

/**
 * Created by Junior Cupe Casquina on 6/16/2015.
 */
public interface ISensorUpdater {
    boolean activateSensor(String name);// the string is the id of the component(SENSOR)

    boolean deactivateSensor(String name);
}
