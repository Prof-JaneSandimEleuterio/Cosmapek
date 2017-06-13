package mapekcosmos.components.core;

import mapekcosmos.interfaces.IComponent;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public class Component implements IComponent {
    private String name;
    private String feature;
    private boolean isSensor;
    private int orderT;
    private boolean isActivated;

    public Component(String name, String feature, boolean isSensor, int orderT) {
        this.name = name;
        this.feature = feature;
        this.isSensor = isSensor;
        this.orderT = orderT;
        this.isActivated = false;
    }


    @Override public String getFeatureName() {
        return feature;
    }

    @Override public int getPosition() {
        return orderT;
    }

    @Override public String getName() {
        return name;
    }

    @Override public int compareTo(Object o) {
        IComponent comp = (IComponent) o;
        //if (comp.getName() == this.getName() || comp.getPosition() == this.getPosition()) {
        if (comp.getName() == this.getName() && comp.getPosition() == this.getPosition()) {
            return 0;
        } else {
            if (this.getPosition() < comp.getPosition()) {
                return -1;
            } else if (this.getPosition() > comp.getPosition()) {
                return 1;
            }
        }
        return 0;
    }
}
