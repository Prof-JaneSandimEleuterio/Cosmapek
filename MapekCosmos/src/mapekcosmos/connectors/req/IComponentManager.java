package mapekcosmos.connectors.req;

import mapekcosmos.interfaces.IComponent;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public interface IComponentManager {
    LinkedList<IComponent> getComponentsWith(String feature);

    boolean hasComponentsWith(String feature);

}
