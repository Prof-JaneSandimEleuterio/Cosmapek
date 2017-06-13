package mapekcosmos.planner;

/**
 * @author Junior Cupe Casquina
 */
public interface IInterfaceTags {
    //provided
    static final String IManagerProv = "IManager";

    static final String IPlanningManagerProv = "IPlanningManager";
    //required
    static final String IAnalysisManagerReq = "IAnalysisManager";
    static final String IComponentManagerReq = "IComponentManager";
    static final String IConnectorManagerReq = "IConnectorManager";
    static final String ISensorManagerReq = "ISensorManager";
    static final String IVariabilityManagerReq = "IVariabilityManager";
    //others
    static final String IComponentManagerTag = "IComponentManager";
    static final String ISensorManagerTag = "ISensorManager";
    static final String IConnectorManagerTag = "IConnectorManager";
    static final String IFeatureManagerTag = "IFeatureManager";
    static final String IVariabilityManagerTag = "IVariabilityManager";
    static final String IReadingManagerTag = "IReadingManager";
    static final String IAnalysisManagerTag = "IAnalysisManager";
    static final String IPlanningManagerTag = "IPlanningManager";
    static final String IExecutionManagerTag = "IExecutionManager";
    static final String IControllerManagerTag = "IControllerManager";

}
