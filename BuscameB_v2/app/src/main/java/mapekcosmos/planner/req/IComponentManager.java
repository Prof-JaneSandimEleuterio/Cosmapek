package mapekcosmos.planner.req;

import mapekcosmos.interfaces.IComponent;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface IComponentManager {

    LinkedList<IComponent> getComponentsWith(String feature);

    boolean hasComponentsWith(String feature);

}
