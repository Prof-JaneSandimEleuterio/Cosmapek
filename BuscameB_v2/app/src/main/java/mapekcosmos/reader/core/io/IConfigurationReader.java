package mapekcosmos.reader.core.io;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Junior Cupe Casquina
 */
public interface IConfigurationReader {
    public void readFromFile(File file) throws UnsupportedModelException, FileNotFoundException;
}
