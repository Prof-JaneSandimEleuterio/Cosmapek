package mapekcosmos.conn_variability_reader.impl;

import mapekcosmos.conn_variability_reader.prov.IManager;

class Adapter
    implements mapekcosmos.reader.req.IVariabilityManager, mapekcosmos.conn_variability_reader.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void setVariabilityPath(String variabilityPath) {
        mapekcosmos.variability.prov.IVariabilityManager compVariability =
            (mapekcosmos.variability.prov.IVariabilityManager) this.manager
                .getRequiredInterface(IVariabilityManagerTag);
        compVariability.setVariabilityPath(variabilityPath);
    }

    @Override public synchronized void read() {
        mapekcosmos.variability.prov.IVariabilityManager compVariability =
            (mapekcosmos.variability.prov.IVariabilityManager) this.manager
                .getRequiredInterface(IVariabilityManagerTag);
        compVariability.read();
    }
}
