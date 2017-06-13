package mapekcosmos.variability.core.fm2.io;


import mapekcosmos.variability.core.fm2.IFeatureModel;

import java.io.File;

/**
 * @author Junior Cupe Casquina
 */
public interface IFeatureModelReader {

    void readFromFile(File input);

    IFeatureModel getFeatureModel();

}
