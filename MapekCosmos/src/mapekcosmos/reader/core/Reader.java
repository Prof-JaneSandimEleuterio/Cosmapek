package mapekcosmos.reader.core;

import mapekcosmos.reader.core.io.IConfigurationReader;
import mapekcosmos.reader.core.io.UnsupportedModelException;
import mapekcosmos.reader.core.io.xml.XmlConfigurationReader;
import mapekcosmos.reader.prov.IManager;
import mapekcosmos.reader.req.IVariabilityManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;

/**
 * @author Junior Cupe Casquina
 */
public class Reader implements IInterfaceTags {
    private IManager manager;
    private String configurationPath;
    private IVariabilityManager variability;

    private IConfigurationReader confReader;

    public  Reader(IManager manager) {
        this.manager = manager;
        this.confReader = new XmlConfigurationReader(this.manager);
    }

    public synchronized void setVariabilityPath(String variabilityPath) {
        variability = (IVariabilityManager) manager.getRequiredInterface(IVariabilityManagerReq);
        variability.setVariabilityPath(variabilityPath);
    }

    public synchronized void read() {
        //File input = new File(URI.create(getConfigurationPath()));
        File input = new File(getConfigurationPath());
        try {
            confReader.readFromFile(input);
        } catch (UnsupportedModelException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        variability.read();
    }

    private String getConfigurationPath() {
        return configurationPath;
    }

    public synchronized void setConfigurationPath(String configurationPath) {
        this.configurationPath = configurationPath;
    }
}
