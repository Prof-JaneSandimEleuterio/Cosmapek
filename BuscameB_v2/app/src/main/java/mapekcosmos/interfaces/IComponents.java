package mapekcosmos.interfaces;

/**
 * Created by ArchyWin on 5/28/2015.
 */
public interface IComponents extends Iterable<IComponent> {
    void add(IComponent component);

    void clear();

    boolean isEmpty();
}
