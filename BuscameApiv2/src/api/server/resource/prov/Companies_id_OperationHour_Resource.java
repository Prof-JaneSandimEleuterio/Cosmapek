package api.server.resource.prov;

import api.server.representation.CompanyOperationHourList;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Companies_id_OperationHour_Resource {
    @Get
    CompanyOperationHourList getCompanyOperationHours() throws Exception;

    @Delete
    void removeAllCompanyOperationHours() throws Exception;

    @Post
    api.server.representation.CompanyOperationHour addAnOperationHour(api.server.representation.CompanyOperationHour bean) throws Exception;
}
