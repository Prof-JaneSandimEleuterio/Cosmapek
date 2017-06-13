package unicamp.buscame.conn_company_ui.impl;

import unicamp.buscame.conn_company_ui.prov.IManager;
import unicamp.buscame.util.representation.CompanyDetails;
import unicamp.buscame.util.representation.CompanyList;
import unicamp.buscame.util.representation.CompanyOperationHourList;
import unicamp.buscame.util.representation.CompanyProductList;

class Adapter
    implements unicamp.buscame.ui.req.ICompanyManager, unicamp.buscame.conn_company_ui.impl.IInterfaceTags {
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
    public synchronized CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies) {
        unicamp.buscame.company.prov.ICompanyManager compCompany =
                ( unicamp.buscame.company.prov.ICompanyManager) this.manager.getRequiredInterface(ICompanyManagerTag);

        return compCompany.getCompanyList(longitude, latitude, numCompanies);
    }

    @Override
    public synchronized CompanyDetails getCompanyDetails(String companyId) {
        unicamp.buscame.company.prov.ICompanyManager compCompany =
                ( unicamp.buscame.company.prov.ICompanyManager) this.manager.getRequiredInterface(ICompanyManagerTag);
        return compCompany.getCompanyDetails(companyId);
    }

    @Override
    public synchronized CompanyProductList getCompanyProductList(String companyId) {
        unicamp.buscame.company.prov.ICompanyManager compCompany =
                ( unicamp.buscame.company.prov.ICompanyManager) this.manager.getRequiredInterface(ICompanyManagerTag);
        return compCompany.getCompanyProductList(companyId);
    }

    @Override
    public synchronized CompanyOperationHourList getOperationHourList(String companyId) {
        unicamp.buscame.company.prov.ICompanyManager compCompany =
                ( unicamp.buscame.company.prov.ICompanyManager) this.manager.getRequiredInterface(ICompanyManagerTag);
        return compCompany.getOperationHourList(companyId);
    }
}
