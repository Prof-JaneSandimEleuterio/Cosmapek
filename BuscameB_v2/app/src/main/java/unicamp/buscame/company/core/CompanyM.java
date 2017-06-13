package unicamp.buscame.company.core;

import unicamp.buscame.company.prov.IManager;
import unicamp.buscame.company.req.IConfigurationManager;
import unicamp.buscame.company.req.ILocalizationManager;
import unicamp.buscame.company.req.IProductManager;
import unicamp.buscame.util.representation.CompanyDetails;
import unicamp.buscame.util.representation.CompanyList;
import unicamp.buscame.util.representation.CompanyOperationHourList;
import unicamp.buscame.util.representation.CompanyProductList;

/**
 * @author Junior Cupe Casquina
 */
public class CompanyM {
    private IManager manager;

    private ILocalizationManager localizationManager;
    private IConfigurationManager configurationManager;
    private IProductManager productManager;

    public CompanyM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
        this.localizationManager =
                (ILocalizationManager) manager.getRequiredInterface("ILocalizationManager");
        this.configurationManager=
                (IConfigurationManager) manager.getRequiredInterface("IConfigurationManager");
        this.productManager=
                (IProductManager) manager.getRequiredInterface("IProductManager");
    }

    public synchronized CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies) {
        getManagers();
        return localizationManager.getCompanyList(longitude,latitude,numCompanies);
    }

    public synchronized CompanyDetails getCompanyDetails(String companyId) {
        getManagers();
        //implement
        return null;
    }

    public synchronized CompanyProductList getCompanyProductList(String companyId) {
        getManagers();
        return productManager.getCompanyProductList(companyId);
    }

    public synchronized CompanyOperationHourList getOperationHourList(String companyId) {
        getManagers();
        return configurationManager.getOperationHourList(companyId);
    }
}
