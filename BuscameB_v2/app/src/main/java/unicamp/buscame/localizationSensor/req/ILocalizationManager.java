package unicamp.buscame.localizationSensor.req;

import unicamp.buscame.util.representation.CompanyList;

public interface ILocalizationManager {
    CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies);
}
