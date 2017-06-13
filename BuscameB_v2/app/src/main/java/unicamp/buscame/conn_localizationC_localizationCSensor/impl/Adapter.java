package unicamp.buscame.conn_localizationC_localizationCSensor.impl;

import unicamp.buscame.conn_localizationC_localizationCSensor.prov.IManager;
import unicamp.buscame.util.representation.CompanyList;

class Adapter
    implements unicamp.buscame.localizationCSensor.req.ILocalizationManager, unicamp.buscame.conn_localizationC_localizationCSensor.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies) {
        unicamp.buscame.localizationC.prov.ILocalizationManager compLocalization =
                (unicamp.buscame.localizationC.prov.ILocalizationManager) this.manager.getRequiredInterface(ILocalizationManagerTag);
        return compLocalization.getCompanyList(longitude,latitude,numCompanies);
    }
}
