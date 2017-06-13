package mapekcosmos.components;

import mapekcosmos.interfaces.IComponent;
import mapekcosmos.interfaces.IComponents;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class ComponentsTest implements IInterfaceTags {
    private mapekcosmos.components.prov.IManager comp;
    private mapekcosmos.components.prov.IComponentManager compIComp;
    //requirements
    //mapekcosmos.connectors

    @org.junit.Before public void setUp() throws Exception {
        // Here begin the important
        comp = mapekcosmos.components.impl.ComponentFactory.createInstance();
        compIComp =
            (mapekcosmos.components.prov.IComponentManager) comp.getProvidedInterface(IComponentManagerTag);
    }

    //void createAComponent(String name, String feature, boolean isSensor,int orderT)
    @org.junit.Test public void createAComponent() {
        //clean
        compIComp.clearComponents();
        //Data
        String nameInput = "compA";
        String featureInput = "FeatureA";
        boolean isSensorInput = false;
        int orderTInput = 1;
        compIComp.createAComponent(nameInput, featureInput, isSensorInput, orderTInput);
        //test
        boolean resp = compIComp.hasComponentsWith(featureInput);
        assertTrue(resp);
    }

    //  LinkedList<IComponent> getComponentsWith(String feature)
    @org.junit.Test public void getComponentsWith() {
        //clean
        compIComp.clearComponents();
        //Data
        String nameInput = "CompB";
        String featureInput = "FeatureB";
        boolean isSensorInput = false;
        int orderTInput = 2;
        compIComp.createAComponent(nameInput, featureInput, isSensorInput, orderTInput);

        //test
        LinkedList<IComponent> resp;
        resp = compIComp.getComponentsWith(featureInput);
        for (IComponent c : resp) {
            assertEquals(c.getFeatureName(), featureInput);
        }
    }

    //  boolean hasComponentsWith(String feature)
    @org.junit.Test public void hasComponentsWith() {
        //clean
        compIComp.clearComponents();
        //Data
        String nameInput = "compC";
        String featureInput = "FeatureC";
        boolean isSensorInput = false;
        int orderTInput = 3;
        compIComp.createAComponent(nameInput, featureInput, isSensorInput, orderTInput);

        boolean r = compIComp.hasComponentsWith(featureInput);
        assertTrue(r);

    }

    //ISensors getComponentsInRuntime();
    @org.junit.Test public void getComponentsInRuntime() {
        //clean
        compIComp.clearComponents();
        //Data
        String inputName = "SensorD";
        String inputFeature = "FeatureD";
        boolean inputIsSensor = true;
        int inputOrderT = 4;
        compIComp.createAComponent(inputName, inputFeature, inputIsSensor, inputOrderT);

        LinkedList<String> sol = new LinkedList<String>();
        sol.add(inputFeature);

        //test
        compIComp.updateRuntimeRegistry(sol);
        IComponents group = compIComp.getComponentsInRuntime();
        IComponent temp = null;
        for (IComponent c : group) {
            if (c.getFeatureName() == inputFeature) {
                temp = c;
            }
        }
        assertEquals(temp.getName(), inputName);
    }

    // void updateRuntimeRegistry(LinkedList<String> sol)
    @org.junit.Test public void updateRuntimeRegistry() {
        //clean
        compIComp.clearComponents();
        String inputName = "CompE";
        String inputFeature = "FeatureE";
        boolean inputIsSensor = false;
        int inputOrderT = 5;
        compIComp.createAComponent(inputName, inputFeature, inputIsSensor, inputOrderT);

        //output
        LinkedList<String> sol = new LinkedList<String>();
        sol.add(inputFeature);

        //test
        compIComp.updateRuntimeRegistry(sol);

        IComponents group = compIComp.getComponentsInRuntime();
        for (IComponent c : group) {
            assertEquals(c.getName(), inputName);
        }
    }

    //void clearComponents();
    @org.junit.Test public void clearComponents() {
        //clean
        compIComp.clearComponents();
        //Data
        String inputName = "CompF";
        String inputFeature = "FeatureF";
        boolean inputIsSensor = false;
        int inputOrderT = 6;
        compIComp.createAComponent(inputName, inputFeature, inputIsSensor, inputOrderT);

        //test
        compIComp.clearComponents();
        boolean r = compIComp.hasComponentsWith(inputFeature);
        assertTrue(!r);

    }
}
