package unicamp.buscame.conn_localizationC_company.impl;

import unicamp.buscame.conn_localizationC_company.prov.IManager;
import unicamp.buscame.util.representation.CompanyList;

class Adapter
    implements unicamp.buscame.company.req.ILocalizationManager, unicamp.buscame.conn_localizationC_company.impl.IInterfaceTags {
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
