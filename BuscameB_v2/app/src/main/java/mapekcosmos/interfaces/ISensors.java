package mapekcosmos.interfaces;

/**
 * Created by ArchyWin on 5/26/2015.
 */
public interface ISensors extends Iterable<ISensor> {

    void add(ISensor sensor);

    void clear();

    boolean isEmpty();
}
