package mapekcosmos.connectors.core;

import mapekcosmos.connectors.prov.IManager;
import mapekcosmos.connectors.req.IComponentManager;
import mapekcosmos.connectors.req.ISensorManager;
import mapekcosmos.interfaces.IComponent;
import mapekcosmos.interfaces.IConnector;
import mapekcosmos.interfaces.IConnectors;
import mapekcosmos.interfaces.ISensor;

import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Junior Cupe Casquina
 */
public class ConnectorM {
    private IManager manager;
    private IConnectors connectors; //set of mapekcosmos.connectors
    private IConnectors connectorsinRuntime;// set of mapekcosmos.connectors
    private IComponentManager componentManager;
    private ISensorManager sensorManager;


    public ConnectorM(IManager manager) {
        this.manager = manager;
        this.connectors = new Connectors();
        this.connectorsinRuntime = new Connectors();

    }

    private synchronized  void getManagers() {
        this.componentManager =
            (IComponentManager) manager.getRequiredInterface("IComponentManager");
        this.sensorManager = (ISensorManager) manager.getRequiredInterface("ISensorManager");
    }

    public synchronized void createAConnector(String name, String origin, String destination, int orderT) {
        getManagers();
        connectors.add(new Connector(name, origin, destination, orderT));
    }

    public synchronized LinkedList<IConnector> getConnectorsWith(String feature) {
        getManagers();
        SortedSet<IConnector> resp = new TreeSet<IConnector>();

        boolean hasComponents = componentManager.hasComponentsWith(feature);
        boolean hasSensors = sensorManager.hasSensorsWith(feature);
        if ((!hasComponents) && (!hasSensors)) {
            return new LinkedList<IConnector>();
        }
        if (hasComponents) {
            LinkedList<IComponent> components = componentManager.getComponentsWith(feature);
            for (IConnector connect : connectors) {
                for (IComponent comp : components) {
                    String senName = comp.getName();
                   // if (connect.getOrigin().equals(senName) || connect.getDestination().equals(senName)) {
                    if (connect.getOrigin().equals(senName)) {
                        resp.add(connect);
                    }
                }
            }
        } else {
            LinkedList<ISensor> sensors = sensorManager.getSensorsWith(feature);
            for (IConnector connect : connectors) {
                for (ISensor sen : sensors) {
                    String senName = sen.getName();
                    //if (connect.getOrigin().equals(senName) || connect.getDestination()
                    if (connect.getOrigin().equals(senName)) {
                        resp.add(connect);
                    }
                }
            }
        }
        LinkedList<IConnector> temp = new LinkedList<IConnector>();
        for (IConnector conne : resp) {
            temp.add(conne);
        }
        return temp;
    }

    public synchronized boolean hasConnectorsWith(String feature) {
        getManagers();
        if (getConnectorsWith(feature).size() == 0) {
            return false;
        }
        return true;
    }

    public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        getManagers();
        connectorsinRuntime.clear();
        for (String s : sol) {
            for (IConnector conn : getConnectorsWith(s)) {
                connectorsinRuntime.add(conn);
            }
        }
    }

    public synchronized void clearConnectors() {
        getManagers();
        connectorsinRuntime.clear();
        connectors.clear();

    }

    public synchronized IConnectors getConnectorsInRuntime() {
        return connectorsinRuntime;
    }

    public synchronized boolean hasConnectorsInRuntime() {
        getManagers();
        return connectorsinRuntime.isEmpty();
    }
}
