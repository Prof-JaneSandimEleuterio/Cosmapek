package unicamp.buscame.conn_localization_company.impl;

import unicamp.buscame.conn_localization_company.prov.IManager;
import unicamp.buscame.util.representation.CompanyList;

class Adapter
    implements unicamp.buscame.company.req.ILocalizationManager, unicamp.buscame.conn_localization_company.impl.IInterfaceTags {
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
