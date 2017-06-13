package api.server.resource.prov;

import org.restlet.resource.Get;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface ImagesResource {
    @Get
    api.server.representation.ImageList getAImagesList() throws Exception;
    //parameters: localization longitude,latitude
    //parameters: number
    //parameters: random (number)
}
