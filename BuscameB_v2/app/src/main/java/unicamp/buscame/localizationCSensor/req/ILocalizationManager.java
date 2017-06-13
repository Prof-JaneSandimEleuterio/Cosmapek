package unicamp.buscame.localizationCSensor.req;

import unicamp.buscame.util.representation.CompanyList;

public interface ILocalizationManager {
    CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies);
}
