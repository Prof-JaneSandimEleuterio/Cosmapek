package mapekcosmos.variability.core.fm2.io;



import mapekcosmos.variability.core.fm2.IFeatureModel;

import java.io.*;

/**
 * Created by ArchyWin on 3/23/2015.
 */
abstract public class AbstractFeatureModelReader implements IFeatureModelReader {
    protected IFeatureModel featureModel = null;
    protected File fmFile;

    @Override public IFeatureModel getFeatureModel() {
        return featureModel;
    }

    @Override public void readFromFile(File input) {
        this.fmFile = input;
        String filePath = input.getPath();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            parseInputStream(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedModelException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void parseInputStream(InputStream inputStream)
        throws UnsupportedModelException, mapekcosmos.variability.core.fm2.io.UnsupportedModelException;

}
