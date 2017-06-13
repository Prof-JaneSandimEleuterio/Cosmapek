package mapekcosmos.components.core;

import mapekcosmos.components.prov.IManager;
import mapekcosmos.interfaces.IComponent;
import mapekcosmos.interfaces.IComponents;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public class ComponentM {
    IManager manager;
    private IComponents components; //set of mapekcosmos.components
    private IComponents componentsinRuntime; //set of mapekcosmos.components

    public ComponentM(IManager manager) {
        this.manager = manager;
        this.components = new Components();
        this.componentsinRuntime = new Components();
    }

    public synchronized void createAComponent(String name, String feature, boolean isSensor, int orderT) {

        components.add(new Component(name, feature, isSensor, orderT));
    }

    public synchronized LinkedList<IComponent> getComponentsWith(String feature) {
        LinkedList<IComponent> resp = new LinkedList<IComponent>();
        for (IComponent comp : components) {
            if (comp.getFeatureName().equals(feature)) {
                resp.add(comp);
            }
        }
        return resp;
    }

    public synchronized boolean hasComponentsWith(String feature) {
        if (getComponentsWith(feature).size() == 0) {
            return false;
        }
        return true;
    }

    public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        componentsinRuntime.clear();
        for (String s : sol) {
            for (IComponent sen : getComponentsWith(s)) {
                componentsinRuntime.add(sen);
            }
        }
    }

    public synchronized void clearComponents() {

        componentsinRuntime.clear();
        components.clear();

    }

    public synchronized IComponents getComponentsInRuntime() {
        return componentsinRuntime;
    }
}
