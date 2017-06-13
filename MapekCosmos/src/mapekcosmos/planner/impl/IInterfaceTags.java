package mapekcosmos.planner.impl;

/**
 * @author Junior Cupe Casquina
 */
interface IInterfaceTags {
    //provided
    static final String IManagerProv = "IManager";

    static final String IPlanningManagerProv = "IPlanningManager";
    //required
    static final String IAnalysisManagerReq = "IAnalysisManager";
    static final String IComponentManagerReq = "IComponentManager";
    static final String IConnectorManagerReq = "IConnectorManager";
    static final String ISensorManagerReq = "ISensorManager";
    static final String IVariabilityManagerReq = "IVariabilityManager";
}
