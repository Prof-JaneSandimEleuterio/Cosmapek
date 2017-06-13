package unicamp.buscame.conn_localization_localizationSensor.impl;

import unicamp.buscame.conn_localization_localizationSensor.prov.IManager;
import unicamp.buscame.util.representation.CompanyList;

class Adapter
    implements unicamp.buscame.localizationSensor.req.ILocalizationManager, unicamp.buscame.conn_localization_localizationSensor.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies) {
        unicamp.buscame.localization.prov.ILocalizationManager compLocalization =
                (unicamp.buscame.localization.prov.ILocalizationManager) this.manager.getRequiredInterface(ILocalizationManagerTag);
        return compLocalization.getCompanyList(longitude,latitude,numCompanies);
    }
}
