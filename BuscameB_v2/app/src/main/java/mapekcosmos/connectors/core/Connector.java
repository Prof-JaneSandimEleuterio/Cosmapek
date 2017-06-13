package mapekcosmos.connectors.core;

import mapekcosmos.interfaces.IConnector;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public class Connector implements IConnector {
    String name;
    String origin;
    String destination;
    int orderT;

    public Connector(String name, String origin, String destination, int orderT) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.orderT = orderT;
    }

    @Override public String getOrigin() {
        return origin;
    }

    @Override public String getDestination() {
        return destination;
    }

    @Override public int getPosition() {
        return orderT;
    }

    @Override public String getName() {
        return name;
    }

    @Override public int compareTo(Object o) {
        IConnector con = (IConnector) o;
        if (con.getName() == this.getName() && con.getPosition() == this.getPosition()) {
       // if (con.getName() == this.getName() || con.getPosition() == this.getPosition()) {
            return 0;
        } else {
            if (this.getPosition() < con.getPosition()) {
                return -1;
            } else if (this.getPosition() > con.getPosition()) {
                return 1;
            }
        }
        return 0;
    }
}
