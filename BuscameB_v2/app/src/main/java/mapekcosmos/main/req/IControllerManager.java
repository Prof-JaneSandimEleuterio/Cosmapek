package mapekcosmos.main.req;

/**
 * @author Junior Cupe Casquina
 */
public interface IControllerManager {

    void execute();

    void setTimeLapse(long monitoringTimeLapse);

    void monitor();

    void setJarPath(String jarPath);
}
