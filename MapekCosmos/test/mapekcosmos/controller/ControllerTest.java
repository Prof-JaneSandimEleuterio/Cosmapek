package mapekcosmos.controller;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class ControllerTest implements IInterfaceTags {
    ;

    private mapekcosmos.controller.prov.IManager controll;
    private mapekcosmos.controller.prov.IControllerManager controllIControll;
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

    private mapekcosmos.analyzer.prov.IManager analy;
    private mapekcosmos.analyzer.prov.IAnalysisManager analyIAnaly;
    private mapekcosmos.planner.prov.IManager plann;
    private mapekcosmos.planner.prov.IPlanningManager plannIPlann;
    private mapekcosmos.executer.prov.IManager execu;
    private mapekcosmos.executer.prov.IExecutionManager execuIExecu;
    //mapekcosmos.connectors
    private mapekcosmos.conn_analyzer_controller.prov.IManager analy_controll;
    private mapekcosmos.conn_analyzer_planner.prov.IManager analy_plann;
    private mapekcosmos.conn_components_connectors.prov.IManager comp_conn;
    private mapekcosmos.conn_components_planner.prov.IManager comp_plann;
    private mapekcosmos.conn_components_variability.prov.IManager comp_varia;
    private mapekcosmos.conn_connectors_planner.prov.IManager conn_plann;
    private mapekcosmos.conn_connectors_variability.prov.IManager conn_varia;
    private mapekcosmos.conn_executer_controller.prov.IManager execu_controll;
    private mapekcosmos.conn_features_variability.prov.IManager feature_varia;
    private mapekcosmos.conn_planner_controller.prov.IManager plann_controll;
    private mapekcosmos.conn_planner_executer.prov.IManager plann_execu;
    private mapekcosmos.conn_sensors_analyzer.prov.IManager sens_analy;
    private mapekcosmos.conn_sensors_connectors.prov.IManager sens_conn;
    private mapekcosmos.conn_sensors_planner.prov.IManager sens_plann;
    private mapekcosmos.conn_sensors_variability.prov.IManager sens_varia;
    private mapekcosmos.conn_variability_planner.prov.IManager varia_plann;


    @org.junit.Before public void setUp() throws Exception {
        comp = mapekcosmos.components.impl.ComponentFactory.createInstance();
        compIComp =
            (mapekcosmos.components.prov.IComponentManager) comp.getProvidedInterface(IComponentManagerTag);
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorManager) sens.getProvidedInterface(ISensorManagerTag);

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

        feature = mapekcosmos.features.impl.ComponentFactory.createInstance();
        featureIFeature =
            (mapekcosmos.features.prov.IFeatureManager) feature.getProvidedInterface(IFeatureManagerTag);

        varia = mapekcosmos.variability.impl.ComponentFactory.createInstance();

        comp_varia = mapekcosmos.conn_components_variability.impl.ComponentFactory.createInstance();
        comp_varia.setRequiredInterface(IComponentManagerTag, compIComp);
        sens_varia = mapekcosmos.conn_sensors_variability.impl.ComponentFactory.createInstance();
        sens_varia.setRequiredInterface(ISensorManagerTag, sensISens);
        feature_varia = mapekcosmos.conn_features_variability.impl.ComponentFactory.createInstance();
        feature_varia.setRequiredInterface(IFeatureManagerTag, featureIFeature);
        conn_varia = mapekcosmos.conn_connectors_variability.impl.ComponentFactory.createInstance();
        conn_varia.setRequiredInterface(IConnectorManagerTag, connIConn);

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

        analy = mapekcosmos.analyzer.impl.ComponentFactory.createInstance();

        sens_analy = mapekcosmos.conn_sensors_analyzer.impl.ComponentFactory.createInstance();
        sens_analy.setRequiredInterface(ISensorManagerTag, sensISens);

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

        plann_execu = mapekcosmos.conn_planner_executer.impl.ComponentFactory.createInstance();
        plann_execu.setRequiredInterface(IPlanningManagerTag, plannIPlann);

        execu.setRequiredInterface(IPlanningManagerTag,
            plann_execu.getProvidedInterface(IPlanningManagerTag));
        execuIExecu =
            (mapekcosmos.executer.prov.IExecutionManager) execu.getProvidedInterface(IExecutionManagerTag);
        // Here begin the important
        controll = mapekcosmos.controller.impl.ComponentFactory.createInstance();
        analy_controll = mapekcosmos.conn_analyzer_controller.impl.ComponentFactory.createInstance();
        analy_controll.setRequiredInterface(IAnalysisManagerTag, analyIAnaly);
        plann_controll = mapekcosmos.conn_planner_controller.impl.ComponentFactory.createInstance();
        plann_controll.setRequiredInterface(IPlanningManagerTag, plannIPlann);
        execu_controll = mapekcosmos.conn_executer_controller.impl.ComponentFactory.createInstance();
        execu_controll.setRequiredInterface(IExecutionManagerTag, execuIExecu);

        controll.setRequiredInterface(IAnalysisManagerTag,
            analy_controll.getProvidedInterface(IAnalysisManagerTag));
        controll.setRequiredInterface(IPlanningManagerTag,
            plann_controll.getProvidedInterface(IPlanningManagerTag));
        controll.setRequiredInterface(IExecutionManagerTag,
            execu_controll.getProvidedInterface(IExecutionManagerTag));
        controllIControll = (mapekcosmos.controller.prov.IControllerManager) controll
            .getProvidedInterface(IControllerManagerTag);

    }

    //void execute()
    @org.junit.Test public void execute() {
        String jarPath = "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/MapekOsgi/resources/jar";
        long monitoringTimeLapse = 2000; // in milliseconds

        controllIControll.setJarPath(jarPath);
        controllIControll.setTimeLapse(monitoringTimeLapse);
        controllIControll.execute();
        controllIControll.monitor();
    }

    //void setTimeLapse(long monitoringTimeLapse)
    @org.junit.Test public void setTimeLapse() {
    }

    //void monitor()
    @org.junit.Test public void monitor() {
    }

    //void setJarPath(String jarPath)
    @org.junit.Test public void setJarPath() {
    }
}
