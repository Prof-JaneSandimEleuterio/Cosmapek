package mapekcosmos.conn_variability_planner.impl;

import mapekcosmos.conn_variability_planner.prov.IManager;

import java.util.LinkedList;

class Adapter
    implements mapekcosmos.planner.req.IVariabilityManager, mapekcosmos.conn_variability_planner.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures) {
        mapekcosmos.variability.prov.IVariabilityManager compVariability =
            (mapekcosmos.variability.prov.IVariabilityManager) this.manager
                .getRequiredInterface(IVariabilityManagerTag);
        return compVariability.getASolutionWithout(failedFeatures);
    }
}
