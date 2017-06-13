package mapekcosmos.interfaces;

/**
 * Created by ArchyWin on 5/28/2015.
 */
public interface IConnectors extends Iterable<IConnector> {
    void add(IConnector connector);

    void clear();

    boolean isEmpty();
}
