package api.server.resource.prov;

import org.restlet.resource.Get;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface ProductsResource {
    @Get
    api.server.representation.CompanyProductList getAProductList() throws Exception;
    //parameters: localization longitude,latitude
    //parameters: number
    //parameters: random (number)
}
