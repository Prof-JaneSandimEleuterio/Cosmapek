package mapekcosmos.components.prov;

import mapekcosmos.interfaces.IComponent;
import mapekcosmos.interfaces.IComponents;

import java.util.LinkedList;

public interface IComponentManager {

    void createAComponent(String name, String feature, boolean isSensor, int orderT);

    LinkedList<IComponent> getComponentsWith(String feature);

    boolean hasComponentsWith(String feature);

    IComponents getComponentsInRuntime();

    void updateRuntimeRegistry(LinkedList<String> sol);

    void clearComponents();

}
