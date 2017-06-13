package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Products_idResource {
    @Get
    api.server.representation.CompanyProduct getAProduct() throws Exception;

    @Put
    api.server.representation.CompanyProduct updateAProduct(api.server.representation.CompanyProduct bean) throws Exception;

    @Delete
    void removeAProduct() throws Exception;
}
