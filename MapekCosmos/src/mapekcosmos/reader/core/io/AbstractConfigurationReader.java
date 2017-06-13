package mapekcosmos.reader.core.io;

import java.io.*;

/**
 * @author Junior Cupe Casquina
 */
public abstract class AbstractConfigurationReader implements IConfigurationReader {
    protected File configFile;

    @Override public void readFromFile(File file)
        throws UnsupportedModelException, FileNotFoundException {
        this.configFile = file;
        String filePath = file.getPath();
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(filePath);
            parseInputStream(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected abstract void parseInputStream(InputStream inputStream)
        throws UnsupportedModelException;
}
