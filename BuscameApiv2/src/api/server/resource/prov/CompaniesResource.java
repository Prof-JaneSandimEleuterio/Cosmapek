package api.server.resource.prov;

import org.restlet.resource.Get;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface CompaniesResource {
    @Get
    api.server.representation.CompanyList getACompanyList() throws Exception;
    //parameters: localization longitude,latitude
    //parameters: Number
    //parameters: opened/closed
    //parameters: random (number)
}
