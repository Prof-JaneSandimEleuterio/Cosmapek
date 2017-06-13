package unicamp.buscame.productCSensor.req;

/**
 * Created by ArchyWin on 6/16/2015.
 */
public interface ISensorUpdater {
    boolean activateSensor(String name);

    boolean deactivateSensor(String name);
}
