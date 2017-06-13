package unicamp.buscame.company.prov;

import unicamp.buscame.util.representation.CompanyDetails;
import unicamp.buscame.util.representation.CompanyList;
import unicamp.buscame.util.representation.CompanyOperationHourList;
import unicamp.buscame.util.representation.CompanyProductList;

public interface ICompanyManager {
    CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies); // get a list of company given a localization.

    CompanyDetails getCompanyDetails(String companyId);

    CompanyProductList getCompanyProductList(String companyId);

    CompanyOperationHourList getOperationHourList(String companyId);
}
