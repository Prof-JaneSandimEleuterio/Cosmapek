package unicamp.buscame.localization.prov;

import unicamp.buscame.util.representation.CompanyList;

public interface ILocalizationManager {
    CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies);
}
