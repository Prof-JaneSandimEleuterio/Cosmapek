package api.server.resource.impl;

import api.server.representation.ImageList;
import api.server.resource.prov.Images_Resource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Images_ServerResource extends AbstractServerResource implements Images_Resource, DBConfiguration {

    @Override public ImageList getAllImages() throws Exception {
        return null;
    }

    @Override public void removeAllImages() throws Exception {

    }
}
