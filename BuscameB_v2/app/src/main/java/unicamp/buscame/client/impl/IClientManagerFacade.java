package unicamp.buscame.client.impl;

import unicamp.buscame.client.core.ClientM;
import unicamp.buscame.client.core.ClientMFactory;
import unicamp.buscame.client.prov.IClientManager;
import unicamp.buscame.client.prov.IManager;
import unicamp.buscame.util.representation.ClientLocation;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IClientManagerFacade implements IInterfaceTags,
    IClientManager {
    private IManager manager = null;
    private ClientM clientM;

    IClientManagerFacade(IManager manager) {
        this.manager = manager;
        this.clientM = ClientMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized boolean hasDefaultLocation() {
        return clientM.hasDefaultLocation();
    }

    @Override public synchronized void setDefaultLocalization() {
        clientM.setDefaultLocalization();
    }

    @Override public synchronized void setDefaultLocalization(double longitude, double latitude) {
        clientM.setDefaultLocalization(longitude,latitude);
    }

    @Override public synchronized ClientLocation getDefaultLocalization() {
        return clientM.getDefaultLocalization();
    }
}
