package mapekcosmos.features;

import mapekcosmos.interfaces.IFeatureB;
import mapekcosmos.interfaces.IFeaturesB;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class FeaturesTest implements IInterfaceTags {
    private mapekcosmos.features.prov.IManager feature;
    private mapekcosmos.features.prov.IFeatureManager featureIFeature;
    //requirements
    //mapekcosmos.connectors

    @org.junit.Before public void setUp() throws Exception {
        // Here begin the important
        feature = mapekcosmos.features.impl.ComponentFactory.createInstance();
        featureIFeature =
            (mapekcosmos.features.prov.IFeatureManager) feature.getProvidedInterface(IFeatureManagerTag);
    }

    //void createAFeature(String name)
    @org.junit.Test public void createAFeature() {
        //clean
        featureIFeature.clearFeatures();
        //Data
        String nameInput = "featureA";
        featureIFeature.createAFeature(nameInput);
        //test
        boolean resp = featureIFeature.hasFeaturesWith(nameInput);
        assertTrue(resp);
    }

    //@Override public boolean hasFeaturesWith(String feature)
    @org.junit.Test public void hasFeaturesWith() {
        //clean
        featureIFeature.clearFeatures();
        //Data
        String nameInput = "compD";
        featureIFeature.createAFeature(nameInput);
        boolean r = featureIFeature.hasFeaturesWith(nameInput);
        assertTrue(r);

    }

    //public LinkedList<IFeatureB> getFeaturesWith(String feature)
    @org.junit.Test public void getFeaturesWith() {
        //clean
        featureIFeature.clearFeatures();
        //Data
        String nameInput = "CompB";
        featureIFeature.createAFeature(nameInput);
        //test
        LinkedList<IFeatureB> resp;
        resp = featureIFeature.getFeaturesWith(nameInput);
        for (IFeatureB f : resp) {
            assertEquals(f.getFeatureName(), nameInput);
        }
    }

    //void updateRuntimeRegistry(LinkedList<String> sol)
    @org.junit.Test public void updateRuntimeRegistry() {
        //clean
        featureIFeature.clearFeatures();
        String inputName = "Feature";
        featureIFeature.createAFeature(inputName);

        //output
        LinkedList<String> sol = new LinkedList<String>();
        sol.add(inputName);

        //test
        featureIFeature.updateRuntimeRegistry(sol);

        IFeaturesB group = featureIFeature.getFeaturesInRuntime();
        for (IFeatureB c : group) {
            assertEquals(c.getFeatureName(), inputName);
        }
    }

    //IFeaturesB getFeaturesInRuntime();
    @org.junit.Test public void getFeaturesInRuntime() {
        //clean
        featureIFeature.clearFeatures();
        //Data
        String inputName = "Feature";
        featureIFeature.createAFeature(inputName);

        LinkedList<String> sol = new LinkedList<String>();
        sol.add(inputName);

        //test
        featureIFeature.updateRuntimeRegistry(sol);
        IFeaturesB group = featureIFeature.getFeaturesInRuntime();
        IFeatureB temp = null;
        for (IFeatureB f : group) {
            if (f.getFeatureName() == inputName) {
                temp = f;
            }
        }
        assertEquals(temp.getFeatureName(), inputName);

    }

    //void clearFeatures();
    @org.junit.Test public void clearFeatures() {
        //clean
        featureIFeature.clearFeatures();
        //Data
        String inputName = "Feature";
        featureIFeature.createAFeature(inputName);

        LinkedList<String> sol = new LinkedList<String>();
        sol.add(inputName);
        //test
        featureIFeature.clearFeatures();
        boolean r = featureIFeature.hasFeaturesWith(inputName);
        assertTrue(!r);

    }
}
