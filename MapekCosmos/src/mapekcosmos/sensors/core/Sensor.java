package mapekcosmos.sensors.core;

import mapekcosmos.interfaces.ISensor;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public class Sensor implements ISensor {
    private String name;
    private String feature;
    private boolean isSensor;
    private int orderT;
    private boolean isActivated = false;

    public Sensor(String name, String feature, boolean isSensor, int orderT) {
        this.name = name;
        this.feature = feature;
        this.isSensor = isSensor;
        this.orderT = orderT;
    }

    @Override public synchronized boolean isActivated() {
        /*codigo*/

        return isActivated;
    }

    @Override public synchronized String getFeatureName() {
        return feature;
    }

    @Override public synchronized void setIsActivated(boolean b) {
        isActivated = b;
    }

    @Override public synchronized int getPosition() {
        return orderT;
    }

    @Override public synchronized String getName() {
        return name;
    }

    @Override public synchronized int compareTo(Object o) {
        ISensor sen = (ISensor) o;
        if (sen.getName() == this.getName() && sen.getPosition() == this.getPosition()) {
        //if (sen.getName() == this.getName() || sen.getPosition() == this.getPosition()) {
            return 0;
        } else {
            if (this.getPosition() < sen.getPosition()) {
                return -1;
            } else if (this.getPosition() > sen.getPosition()) {
                return 1;
            }
        }
        return 0;
    }
}
