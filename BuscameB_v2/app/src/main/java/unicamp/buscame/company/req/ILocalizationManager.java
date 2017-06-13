package unicamp.buscame.company.req;

import unicamp.buscame.util.representation.CompanyList;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public interface ILocalizationManager {

    CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies);
}
