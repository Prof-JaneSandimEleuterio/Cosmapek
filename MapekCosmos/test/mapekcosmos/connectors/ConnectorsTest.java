package mapekcosmos.connectors;

import mapekcosmos.interfaces.IConnector;
import mapekcosmos.interfaces.IConnectors;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class ConnectorsTest implements IInterfaceTags {
    private mapekcosmos.connectors.prov.IManager conn;
    private mapekcosmos.connectors.prov.IConnectorManager connIConn;
    //requirements
    private mapekcosmos.components.prov.IManager comp;
    private mapekcosmos.components.prov.IComponentManager compIComp;
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorManager sensISens;
    //mapekcosmos.connectors
    private mapekcosmos.conn_components_connectors.prov.IManager comp_conn;
    private mapekcosmos.conn_sensors_connectors.prov.IManager sens_conn;

    @org.junit.Before public void setUp() throws Exception {
        comp = mapekcosmos.components.impl.ComponentFactory.createInstance();
        compIComp =
            (mapekcosmos.components.prov.IComponentManager) comp.getProvidedInterface(IComponentManagerTag);
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorManager) sens.getProvidedInterface(ISensorManagerTag);

        // Here begin the important
        conn = mapekcosmos.connectors.impl.ComponentFactory.createInstance();

        comp_conn = mapekcosmos.conn_components_connectors.impl.ComponentFactory.createInstance();
        comp_conn.setRequiredInterface(IComponentManagerTag, compIComp);
        sens_conn = mapekcosmos.conn_sensors_connectors.impl.ComponentFactory.createInstance();
        sens_conn.setRequiredInterface(ISensorManagerTag, sensISens);

        conn.setRequiredInterface(IComponentManagerTag,
            comp_conn.getProvidedInterface(IComponentManagerTag));
        conn.setRequiredInterface(ISensorManagerTag,
            sens_conn.getProvidedInterface(ISensorManagerTag));
        connIConn =
            (mapekcosmos.connectors.prov.IConnectorManager) conn.getProvidedInterface(IConnectorManagerTag);

    }

    //void createAConnector(String name, String origin, String destination, int orderT)
    @org.junit.Test public void createAConnector() {
        //clean
        connIConn.clearConnectors();
        compIComp.clearComponents();
        sensISens.clearSensors();
        //Data
        String compName = "CompA";
        String compFeature = "FeatureOriginA";
        boolean compIsSensor = false;
        int compOrderT = 1;
        compIComp.createAComponent(compName, compFeature, compIsSensor, compOrderT);
        assertTrue(compIComp.hasComponentsWith(compFeature));

        String sensName = "SensorA";
        String sensFeature = "FeatureDestinationA";
        boolean sensIsSensor = true;
        int sensOrderT = 2;
        sensISens.createASensor(sensName, sensFeature, sensIsSensor, sensOrderT);
        assertTrue(sensISens.hasSensorsWith(sensFeature));

        String connName = "ConnectorA";
        String connOrigin = "CompA";
        String connDestination = "SensorA";
        int connOrderT = 3;
        connIConn.createAConnector(connName, connOrigin, connDestination, connOrderT);

        //test
        assertTrue(connIConn.hasConnectorsWith(sensFeature));
        assertTrue(connIConn.hasConnectorsWith(compFeature));
    }

    //LinkedList<IConnector> getConnectorsWith(String feature)
    @org.junit.Test public void getConnectorsWith() {
        //clean
        connIConn.clearConnectors();
        compIComp.clearComponents();
        sensISens.clearSensors();
        //Data
        String compName = "CompA";
        String compFeature = "FeatureOriginA";
        boolean compIsSensor = false;
        int compOrderT = 1;
        compIComp.createAComponent(compName, compFeature, compIsSensor, compOrderT);
        assertTrue(compIComp.hasComponentsWith(compFeature));

        String sensName = "SensorA";
        String sensFeature = "FeatureDestinationA";
        boolean sensIsSensor = true;
        int sensOrderT = 2;
        sensISens.createASensor(sensName, sensFeature, sensIsSensor, sensOrderT);
        assertTrue(sensISens.hasSensorsWith(sensFeature));

        String connName = "ConnectorA";
        String connOrigin = "CompA";
        String connDestination = "SensorA";
        int connOrderT = 3;
        connIConn.createAConnector(connName, connOrigin, connDestination, connOrderT);

        LinkedList<IConnector> temp = connIConn.getConnectorsWith(sensFeature);
        IConnector connA = temp.get(0);
        //test
        assertEquals(connA.getDestination(), sensName);
    }

    //boolean hasConnectorsWith(String feature)
    @org.junit.Test public void hasConnectorsWith() {
        //
        connIConn.clearConnectors();
        compIComp.clearComponents();
        sensISens.clearSensors();
        //Data
        String compName = "CompA";
        String compFeature = "FeatureOriginA";
        boolean compIsSensor = false;
        int compOrderT = 1;
        compIComp.createAComponent(compName, compFeature, compIsSensor, compOrderT);
        assertTrue(compIComp.hasComponentsWith(compFeature));
        String sensName = "SensorA";
        String sensFeature = "FeatureDestinationA";
        boolean sensIsSensor = true;
        int sensOrderT = 2;
        sensISens.createASensor(sensName, sensFeature, sensIsSensor, sensOrderT);
        assertTrue(sensISens.hasSensorsWith(sensFeature));

        String connName = "ConnectorA";
        String connOrigin = "CompA";
        String connDestination = "SensorA";
        int connOrderT = 3;
        connIConn.createAConnector(connName, connOrigin, connDestination, connOrderT);

        //test
        boolean res = connIConn.hasConnectorsWith(compFeature);
        assertTrue(res);
    }

    //boolean hasConnectorsInRuntime();
    @org.junit.Test public void hasConnectorsInRuntime() {
        //clean
        connIConn.clearConnectors();
        compIComp.clearComponents();
        sensISens.clearSensors();
        //Data
        String compName = "CompA";
        String compFeature = "FeatureOriginA";
        boolean compIsSensor = false;
        int compOrderT = 1;
        compIComp.createAComponent(compName, compFeature, compIsSensor, compOrderT);
        assertTrue(compIComp.hasComponentsWith(compFeature));
        String sensName = "SensorA";
        String sensFeature = "FeatureDestinationA";
        boolean sensIsSensor = true;
        int sensOrderT = 2;
        sensISens.createASensor(sensName, sensFeature, sensIsSensor, sensOrderT);
        assertTrue(sensISens.hasSensorsWith(sensFeature));

        String connName = "ConnectorA";
        String connOrigin = "CompA";
        String connDestination = "SensorA";
        int connOrderT = 3;
        connIConn.createAConnector(connName, connOrigin, connDestination, connOrderT);

        //output
        LinkedList<String> sol = new LinkedList<String>();
        sol.add(sensFeature);

        //test
        connIConn.updateRuntimeRegistry(sol);

        IConnectors group = connIConn.getConnectorsInRuntime();
        int count = 0;
        boolean resp = true;
        for (IConnector c : group) {
            count++;
        }
        if (count == 0)
            resp = false;
        assertTrue(resp);
    }

    //void updateRuntimeRegistry(LinkedList<String> sol)
    @org.junit.Test public void updateRuntimeRegistry() {
        //clean
        connIConn.clearConnectors();
        compIComp.clearComponents();
        sensISens.clearSensors();
        //Data
        String sensNameA = "SensorA";
        String sensFeatureA = "FeatureDestinationA";
        boolean sensIsSensorA = true;
        int sensOrderTA = 2;
        sensISens.createASensor(sensNameA, sensFeatureA, sensIsSensorA, sensOrderTA);
        assertTrue(sensISens.hasSensorsWith(sensFeatureA));
        //
        String compNameA = "CompA";
        String compFeatureA = "FeatureOriginA"; // get it
        boolean compIsSensorA = false;
        int compOrderTA = 1;
        compIComp.createAComponent(compNameA, compFeatureA, compIsSensorA, compOrderTA);
        assertTrue(compIComp.hasComponentsWith(compFeatureA));

        String connNameA = "ConnectorA";
        String connOriginA = "CompA";
        String connDestinationA = "SensorA";
        int connOrderTA = 4;
        connIConn
            .createAConnector(connNameA, connOriginA, connDestinationA, connOrderTA);//connector

        String compNameB = "CompB";
        String compFeatureB = "FeatureOriginB"; // get it
        boolean compIsSensorB = false;
        int compOrderTB = 3;
        compIComp.createAComponent(compNameB, compFeatureB, compIsSensorB, compOrderTB);
        assertTrue(compIComp.hasComponentsWith(compFeatureB));

        String connNameB = "ConnectorB";
        String connOriginB = "CompB";
        String connDestinationB = "SensorA";
        int connOrderTB = 5;
        connIConn
            .createAConnector(connNameB, connOriginB, connDestinationB, connOrderTB);//connector

        LinkedList<String> sol = new LinkedList<String>();
        sol.add(compFeatureA);
        sol.add(compFeatureB);
        //test
        connIConn.updateRuntimeRegistry(sol);

        IConnectors group = connIConn.getConnectorsInRuntime();
        for (IConnector c : group) {
            assertEquals(c.getDestination(), connDestinationA);
            assertEquals(c.getDestination(), connDestinationB);
        }
        assertTrue(true);
    }

    //void clearConnectors();
    @org.junit.Test public void clearConnectors() {
        //clean
        connIConn.clearConnectors();
        compIComp.clearComponents();
        sensISens.clearSensors();
        //Data
        String sensNameA = "SensorA";
        String sensFeatureA = "FeatureDestinationA";
        boolean sensIsSensorA = true;
        int sensOrderTA = 2;
        sensISens.createASensor(sensNameA, sensFeatureA, sensIsSensorA, sensOrderTA);
        assertTrue(sensISens.hasSensorsWith(sensFeatureA));
        //
        String compNameA = "CompA";
        String compFeatureA = "FeatureOriginA"; // get it
        boolean compIsSensorA = false;
        int compOrderTA = 1;
        compIComp.createAComponent(compNameA, compFeatureA, compIsSensorA, compOrderTA);
        assertTrue(compIComp.hasComponentsWith(compFeatureA));

        String connNameA = "ConnectorA";
        String connOriginA = "CompA";
        String connDestinationA = "SensorA";
        int connOrderTA = 4;
        connIConn
            .createAConnector(connNameA, connOriginA, connDestinationA, connOrderTA);//connector

        //test
        boolean r = connIConn.hasConnectorsWith(connOriginA);
        assertTrue(!r);
    }
}
