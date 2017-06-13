package unicamp.buscame.conn_client_ui.impl;

import unicamp.buscame.conn_client_ui.prov.IManager;
import unicamp.buscame.util.representation.ClientLocation;

class Adapter
    implements unicamp.buscame.ui.req.IClientManager, unicamp.buscame.conn_client_ui.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }
/*
    @Override public void start() {
        mapekcosmos.analyzer.prov.IAnalysisManager compAnalyzer =
            (mapekcosmos.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);
        compAnalyzer.start();
    }
    */

    @Override
    public synchronized boolean hasDefaultLocation() {
        unicamp.buscame.client.prov.IClientManager compClient =
                (unicamp.buscame.client.prov.IClientManager) this.manager.getRequiredInterface(IClientManagerTag);
        return compClient.hasDefaultLocation();
    }

    @Override
    public synchronized void setDefaultLocalization() {
        unicamp.buscame.client.prov.IClientManager compClient =
                (unicamp.buscame.client.prov.IClientManager) this.manager.getRequiredInterface(IClientManagerTag);
        compClient.setDefaultLocalization();
    }

    @Override
    public synchronized void setDefaultLocalization(double longitude, double latitude) {
        unicamp.buscame.client.prov.IClientManager compClient =
                (unicamp.buscame.client.prov.IClientManager) this.manager.getRequiredInterface(IClientManagerTag);
        compClient.setDefaultLocalization(longitude,latitude);
    }

    @Override
    public synchronized ClientLocation getDefaultLocalization() {
        unicamp.buscame.client.prov.IClientManager compClient =
                (unicamp.buscame.client.prov.IClientManager) this.manager.getRequiredInterface(IClientManagerTag);
        return compClient.getDefaultLocalization();
    }
}
