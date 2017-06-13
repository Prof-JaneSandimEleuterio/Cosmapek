package unicamp.buscame.company.impl;

import unicamp.buscame.company.core.CompanyM;
import unicamp.buscame.company.core.CompanyMFactory;

import unicamp.buscame.company.prov.IManager;
import unicamp.buscame.company.prov.ICompanyManager;
import unicamp.buscame.util.representation.CompanyDetails;
import unicamp.buscame.util.representation.CompanyList;
import unicamp.buscame.util.representation.CompanyOperationHourList;
import unicamp.buscame.util.representation.CompanyProductList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ICompanyManagerFacade implements IInterfaceTags, ICompanyManager {
    private IManager manager = null;
    private CompanyM companyM;

    ICompanyManagerFacade(IManager manager) {
        this.manager = manager;
        this.companyM = CompanyMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies) {
        return companyM.getCompanyList(longitude, latitude, numCompanies);
    }

    @Override
    public synchronized CompanyDetails getCompanyDetails(String companyId) {
        return companyM.getCompanyDetails(companyId);
    }

    @Override
    public synchronized CompanyProductList getCompanyProductList(String companyId) {
        return companyM.getCompanyProductList(companyId);
    }

    @Override
    public synchronized CompanyOperationHourList getOperationHourList(String companyId) {
        return companyM.getOperationHourList(companyId);
    }
}
