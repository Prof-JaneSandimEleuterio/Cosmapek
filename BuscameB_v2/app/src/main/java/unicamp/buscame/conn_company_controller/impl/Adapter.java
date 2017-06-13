package unicamp.buscame.conn_company_controller.impl;

import unicamp.buscame.conn_company_controller.prov.IManager;
import unicamp.buscame.util.representation.CompanyDetails;
import unicamp.buscame.util.representation.CompanyList;
import unicamp.buscame.util.representation.CompanyOperationHourList;
import unicamp.buscame.util.representation.CompanyProductList;

class Adapter
    implements unicamp.buscame.controller.req.ICompanyManager, unicamp.buscame.conn_company_controller.impl.IInterfaceTags {
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
                (unicamp.buscame.company.prov.ICompanyManager) this.manager.getRequiredInterface(ICompanyManagerTag);
        compCompany.getCompanyList(longitude, latitude, numCompanies);
        return null;
    }

    @Override
    public synchronized CompanyDetails getCompanyDetails(String companyId) {
        return null;
    }

    @Override
    public synchronized CompanyProductList getCompanyProductList(String companyId) {
        return null;
    }

    @Override
    public synchronized CompanyOperationHourList getOperationHourList(String companyId) {
        return null;
    }
}
