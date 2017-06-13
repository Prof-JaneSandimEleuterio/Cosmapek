package mapekcosmos.main;

import java.io.File;
import java.net.URI;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertTrue;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class MainTest implements IInterfaceTags {
    private mapekcosmos.main.prov.IManager mainM;
    private mapekcosmos.main.prov.ILauncher mainMILaunch;
    //requirements
    private mapekcosmos.components.prov.IManager comp;
    private mapekcosmos.components.prov.IComponentManager compIComp;
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorManager sensISens;
    private mapekcosmos.connectors.prov.IManager conn;
    private mapekcosmos.connectors.prov.IConnectorManager connIConn;
    private mapekcosmos.features.prov.IManager feature;
    private mapekcosmos.features.prov.IFeatureManager featureIFeature;
    private mapekcosmos.variability.prov.IManager varia;
    private mapekcosmos.variability.prov.IVariabilityManager variaIVaria;
    private mapekcosmos.reader.prov.IManager reade;
    private mapekcosmos.reader.prov.IReadingManager readeIReading;
    private mapekcosmos.analyzer.prov.IManager analy;
    private mapekcosmos.analyzer.prov.IAnalysisManager analyIAnaly;
    private mapekcosmos.planner.prov.IManager plann;
    private mapekcosmos.planner.prov.IPlanningManager plannIPlann;
    private mapekcosmos.executer.prov.IManager execu;
    private mapekcosmos.executer.prov.IExecutionManager execuIExecu;
    private mapekcosmos.controller.prov.IManager controll;
    private mapekcosmos.controller.prov.IControllerManager controllIControll;
    //mapekcosmos.connectors
    private mapekcosmos.conn_analyzer_controller.prov.IManager analy_controll;
    private mapekcosmos.conn_analyzer_planner.prov.IManager analy_plann;
    private mapekcosmos.conn_components_connectors.prov.IManager comp_conn;
    private mapekcosmos.conn_components_planner.prov.IManager comp_plann;
    private mapekcosmos.conn_components_reader.prov.IManager comp_reade;
    private mapekcosmos.conn_components_variability.prov.IManager comp_varia;
    private mapekcosmos.conn_connectors_planner.prov.IManager conn_plann;
    private mapekcosmos.conn_connectors_reader.prov.IManager conn_reade;
    private mapekcosmos.conn_connectors_variability.prov.IManager conn_varia;
    private mapekcosmos.conn_controller_main.prov.IManager controll_mainM;
    private mapekcosmos.conn_executer_controller.prov.IManager execu_controll;
    private mapekcosmos.conn_features_reader.prov.IManager feature_reade;
    private mapekcosmos.conn_features_variability.prov.IManager feature_varia;
    private mapekcosmos.conn_planner_controller.prov.IManager plann_controll;
    private mapekcosmos.conn_planner_executer.prov.IManager plann_execu;
    private mapekcosmos.conn_reader_main.prov.IManager reade_mainM;
    private mapekcosmos.conn_sensors_analyzer.prov.IManager sens_analy;
    private mapekcosmos.conn_sensors_connectors.prov.IManager sens_conn;
    private mapekcosmos.conn_sensors_planner.prov.IManager sens_plann;
    private mapekcosmos.conn_sensors_reader.prov.IManager sens_reade;
    private mapekcosmos.conn_sensors_variability.prov.IManager sens_varia;
    private mapekcosmos.conn_variability_planner.prov.IManager varia_plann;
    private mapekcosmos.conn_variability_reader.prov.IManager varia_reade;

    @org.junit.Before public void setUp() throws Exception {

        comp = mapekcosmos.components.impl.ComponentFactory.createInstance();
        compIComp =
            (mapekcosmos.components.prov.IComponentManager) comp.getProvidedInterface(IComponentManagerTag);
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorManager) sens.getProvidedInterface(ISensorManagerTag);

        conn = mapekcosmos.connectors.impl.ComponentFactory.createInstance();
        //mapekcosmos.connectors to conn
        comp_conn = mapekcosmos.conn_components_connectors.impl.ComponentFactory.createInstance();
        comp_conn.setRequiredInterface(IComponentManagerTag, compIComp);
        sens_conn = mapekcosmos.conn_sensors_connectors.impl.ComponentFactory.createInstance();
        sens_conn.setRequiredInterface(ISensorManagerTag, sensISens);
        //sets
        conn.setRequiredInterface(IComponentManagerTag,
            comp_conn.getProvidedInterface(IComponentManagerTag));
        conn.setRequiredInterface(ISensorManagerTag,
            sens_conn.getProvidedInterface(ISensorManagerTag));
        connIConn =
            (mapekcosmos.connectors.prov.IConnectorManager) conn.getProvidedInterface(IConnectorManagerTag);

        feature = mapekcosmos.features.impl.ComponentFactory.createInstance();
        featureIFeature =
            (mapekcosmos.features.prov.IFeatureManager) feature.getProvidedInterface(IFeatureManagerTag);

        varia = mapekcosmos.variability.impl.ComponentFactory.createInstance();
        //mapekcosmos.connectors to varia
        comp_varia = mapekcosmos.conn_components_variability.impl.ComponentFactory.createInstance();
        comp_varia.setRequiredInterface(IComponentManagerTag, compIComp);
        sens_varia = mapekcosmos.conn_sensors_variability.impl.ComponentFactory.createInstance();
        sens_varia.setRequiredInterface(ISensorManagerTag, sensISens);
        feature_varia = mapekcosmos.conn_features_variability.impl.ComponentFactory.createInstance();
        feature_varia.setRequiredInterface(IFeatureManagerTag, featureIFeature);
        conn_varia = mapekcosmos.conn_connectors_variability.impl.ComponentFactory.createInstance();
        conn_varia.setRequiredInterface(IConnectorManagerTag, connIConn);
        //sets
        varia.setRequiredInterface(IComponentManagerTag,
            comp_varia.getProvidedInterface(IComponentManagerTag));
        varia.setRequiredInterface(ISensorManagerTag,
            sens_varia.getProvidedInterface(ISensorManagerTag));
        varia.setRequiredInterface(IFeatureManagerTag,
            feature_varia.getProvidedInterface(IFeatureManagerTag));
        varia.setRequiredInterface(IConnectorManagerTag,
            conn_varia.getProvidedInterface(IConnectorManagerTag));
        variaIVaria = (mapekcosmos.variability.prov.IVariabilityManager) varia
            .getProvidedInterface(IVariabilityManagerTag);

        reade = mapekcosmos.reader.impl.ComponentFactory.createInstance();
        //mapekcosmos.connectors to reade
        comp_reade = mapekcosmos.conn_components_reader.impl.ComponentFactory.createInstance();
        comp_reade.setRequiredInterface(IComponentManagerTag, compIComp);
        sens_reade = mapekcosmos.conn_sensors_reader.impl.ComponentFactory.createInstance();
        sens_reade.setRequiredInterface(ISensorManagerTag, sensISens);
        conn_reade = mapekcosmos.conn_connectors_reader.impl.ComponentFactory.createInstance();
        conn_reade.setRequiredInterface(IConnectorManagerTag, connIConn);
        feature_reade = mapekcosmos.conn_features_reader.impl.ComponentFactory.createInstance();
        feature_reade.setRequiredInterface(IFeatureManagerTag, featureIFeature);
        varia_reade = mapekcosmos.conn_variability_reader.impl.ComponentFactory.createInstance();
        varia_reade.setRequiredInterface(IVariabilityManagerTag, variaIVaria);
        //sets
        reade.setRequiredInterface(IComponentManagerTag,
            comp_reade.getProvidedInterface(IComponentManagerTag));
        reade.setRequiredInterface(ISensorManagerTag,
            sens_reade.getProvidedInterface(ISensorManagerTag));
        reade.setRequiredInterface(IConnectorManagerTag,
            conn_reade.getProvidedInterface(IConnectorManagerTag));
        reade.setRequiredInterface(IFeatureManagerTag,//
            feature_reade.getProvidedInterface(IFeatureManagerTag));
        reade.setRequiredInterface(IVariabilityManagerTag,
            varia_reade.getProvidedInterface(IVariabilityManagerTag));
        readeIReading =
            (mapekcosmos.reader.prov.IReadingManager) reade.getProvidedInterface(IReadingManagerTag);

        analy = mapekcosmos.analyzer.impl.ComponentFactory.createInstance();
        //mapekcosmos.connectors to analy
        sens_analy = mapekcosmos.conn_sensors_analyzer.impl.ComponentFactory.createInstance();
        sens_analy.setRequiredInterface(ISensorManagerTag, sensISens);
        //sets
        analy.setRequiredInterface(ISensorManagerTag,
            sens_analy.getProvidedInterface(ISensorManagerTag));
        analyIAnaly =
            (mapekcosmos.analyzer.prov.IAnalysisManager) analy.getProvidedInterface(IAnalysisManagerTag);

        plann = mapekcosmos.planner.impl.ComponentFactory.createInstance();
        //mapekcosmos.connectors to plan
        comp_plann = mapekcosmos.conn_components_planner.impl.ComponentFactory.createInstance();
        comp_plann.setRequiredInterface(IComponentManagerTag, compIComp);
        sens_plann = mapekcosmos.conn_sensors_planner.impl.ComponentFactory.createInstance();
        sens_plann.setRequiredInterface(ISensorManagerTag, sensISens);
        conn_plann = mapekcosmos.conn_connectors_planner.impl.ComponentFactory.createInstance();
        conn_plann.setRequiredInterface(IConnectorManagerTag, connIConn);
        varia_plann = mapekcosmos.conn_variability_planner.impl.ComponentFactory.createInstance();
        varia_plann.setRequiredInterface(IVariabilityManagerTag, variaIVaria);
        analy_plann = mapekcosmos.conn_analyzer_planner.impl.ComponentFactory.createInstance();
        analy_plann.setRequiredInterface(IAnalysisManagerTag, analyIAnaly);
        //sets
        plann.setRequiredInterface(IComponentManagerTag,
            comp_plann.getProvidedInterface(IComponentManagerTag));
        plann.setRequiredInterface(ISensorManagerTag,
            sens_plann.getProvidedInterface(ISensorManagerTag));
        plann.setRequiredInterface(IConnectorManagerTag,
            conn_plann.getProvidedInterface(IConnectorManagerTag));
        plann.setRequiredInterface(IVariabilityManagerTag,
            varia_plann.getProvidedInterface(IVariabilityManagerTag));
        plann.setRequiredInterface(IAnalysisManagerTag,
            analy_plann.getProvidedInterface(IAnalysisManagerTag));
        plannIPlann =
            (mapekcosmos.planner.prov.IPlanningManager) plann.getProvidedInterface(IPlanningManagerTag);

        execu = mapekcosmos.executer.impl.ComponentFactory.createInstance();
        //mapekcosmos.connectors to execu
        plann_execu = mapekcosmos.conn_planner_executer.impl.ComponentFactory.createInstance();
        plann_execu.setRequiredInterface(IPlanningManagerTag, plannIPlann);
        //seters to execu
        execu.setRequiredInterface(IPlanningManagerTag,
            plann_execu.getProvidedInterface(IPlanningManagerTag));
        execuIExecu =
            (mapekcosmos.executer.prov.IExecutionManager) execu.getProvidedInterface(IExecutionManagerTag);

        controll = mapekcosmos.controller.impl.ComponentFactory.createInstance();
        //mapekcosmos.connectors to controll
        analy_controll = mapekcosmos.conn_analyzer_controller.impl.ComponentFactory.createInstance();
        analy_controll.setRequiredInterface(IAnalysisManagerTag, analyIAnaly);
        plann_controll = mapekcosmos.conn_planner_controller.impl.ComponentFactory.createInstance();
        plann_controll.setRequiredInterface(IPlanningManagerTag, plannIPlann);
        execu_controll = mapekcosmos.conn_executer_controller.impl.ComponentFactory.createInstance();
        execu_controll.setRequiredInterface(IExecutionManagerTag, execuIExecu);
        //setters to control
        controll.setRequiredInterface(IAnalysisManagerTag,
            analy_controll.getProvidedInterface(IAnalysisManagerTag));
        controll.setRequiredInterface(IPlanningManagerTag,
            plann_controll.getProvidedInterface(IPlanningManagerTag));
        controll.setRequiredInterface(IExecutionManagerTag,
            execu_controll.getProvidedInterface(IExecutionManagerTag));

        controllIControll = (mapekcosmos.controller.prov.IControllerManager) controll
            .getProvidedInterface(IControllerManagerTag);
        // Here begin the important

        mainM = mapekcosmos.main.impl.ComponentFactory.createInstance();
        //mapekcosmos.connectors to mainM
        reade_mainM = mapekcosmos.conn_reader_main.impl.ComponentFactory.createInstance();
        reade_mainM.setRequiredInterface(IReadingManagerTag, readeIReading);
        controll_mainM = mapekcosmos.conn_controller_main.impl.ComponentFactory.createInstance();
        controll_mainM.setRequiredInterface(IControllerManagerTag, controllIControll);
        //setters to mainM
        mainM.setRequiredInterface(IReadingManagerTag,
            reade_mainM.getProvidedInterface(IReadingManagerTag));
        mainM.setRequiredInterface(IControllerManagerTag,
            controll_mainM.getProvidedInterface(IControllerManagerTag));

        mainMILaunch = (mapekcosmos.main.prov.ILauncher) mainM.getProvidedInterface(ILauncherProv);



        //Send the object of the manager of the sensor To the mapekcosmos.executer.
        //To do it we will create a Factory of a object and ther will save the object
        //
    }

    //void start()
    @org.junit.Test public void start() {
               // boolean res=mainMILaunch.start();
            //    assertTrue(res);

    }
    @org.junit.Test public void getASolutionWithoutB() {
        //C:\Users\ArchyWin\Dropbox\Codigos\wsJunior\MapekCosmos\resources
        String resourcesPath =
            "file:///C:/COSMAPEK/MapekCosmos/resources";
        String jarPath = "unicamp.buscame.zCosmapek_Configurations";
        File sdcard =  new File(URI.create(resourcesPath));
        File sdcard_config= new File(sdcard,"config.xml");
        File sdcard_variability= new File(sdcard,"variability.xml");
        variaIVaria.setVariabilityPath(sdcard_variability.getPath());
        variaIVaria.read(); // each time I read. The before set is cleaned.

        //Solution

        Set<String> setSol=new TreeSet<String>();
        setSol.add("APP");
        setSol.add("Buscame");
        setSol.add("Configuration");
        setSol.add("ConfigurationServicea");
        setSol.add("Localization");
        setSol.add("LocalizationServiceB");
        setSol.add("ProductB");
        setSol.add("ProductBServiceB");
        //Test
        LinkedList<String> failureFeatures = new LinkedList<String>();
        failureFeatures.add("LocalizationServiceA");
        LinkedList<String> solutions = variaIVaria.getASolutionWithout(failureFeatures);
        failureFeatures.clear();

        LinkedList<String> failureFeaturesR = new LinkedList<String>();
        failureFeaturesR.add("Localization");
        LinkedList<String> solutionsR = variaIVaria.getASolutionWithout(failureFeaturesR);
        failureFeaturesR.clear();

        failureFeatures.add("LocalizationServiceB");
        LinkedList<String> solutions2 = variaIVaria.getASolutionWithout(failureFeatures);
        failureFeatures.clear();
        failureFeatures.add("LocalizationServiceC");
        LinkedList<String> solutions3 = variaIVaria.getASolutionWithout(failureFeatures);
        failureFeatures.clear();
        failureFeatures.add("LocalizationServiceA");
        failureFeatures.add("LocalizationServiceB");
        LinkedList<String> solutions4 = variaIVaria.getASolutionWithout(failureFeatures);
        failureFeatures.clear();
        failureFeatures.add("LocalizationServiceB");
        failureFeatures.add("LocalizationServiceC");
        LinkedList<String> solutions5 = variaIVaria.getASolutionWithout(failureFeatures);
        failureFeatures.clear();
        failureFeatures.add("LocalizationServiceA");
        failureFeatures.add("LocalizationServiceC");
        LinkedList<String> solutions6 = variaIVaria.getASolutionWithout(failureFeatures);
        failureFeatures.clear();
        failureFeatures.add("LocalizationServiceA");
        LinkedList<String> solutions7 = variaIVaria.getASolutionWithout(failureFeatures);

        Set<String> setA=new TreeSet<String>();
        for (int i = 0; i < solutions.size(); i++) {
            setA.add(solutions.get(i));
        }
        assertTrue(setSol.equals(setA));

    }

}
