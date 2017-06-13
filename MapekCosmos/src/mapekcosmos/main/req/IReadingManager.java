package mapekcosmos.main.req;

/**
 * @author Junior Cupe Casquina
 */
public interface IReadingManager {

    void setConfigurationPath(String configurationPath);

    void setVariabilityPath(String variabilityPath);

    void read();
}
