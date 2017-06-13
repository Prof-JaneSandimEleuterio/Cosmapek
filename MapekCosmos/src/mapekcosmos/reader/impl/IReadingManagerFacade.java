package mapekcosmos.reader.impl;

import mapekcosmos.reader.core.Reader;
import mapekcosmos.reader.core.ReaderFactory;
import mapekcosmos.reader.prov.IManager;
import mapekcosmos.reader.prov.IReadingManager;

/**
 * @author Junior Cupe Casquina
 */
class IReadingManagerFacade implements IReadingManager {
    private IManager manager;
    private Reader reader;

    IReadingManagerFacade(IManager manager) {
        this.manager = manager;
        this.reader = ReaderFactory.createInstance(this.manager);
    }

    @Override public synchronized void setConfigurationPath(String configurationPath) {
        reader.setConfigurationPath(configurationPath);
    }

    @Override public synchronized void setVariabilityPath(String variabilityPath) {
        reader.setVariabilityPath(variabilityPath);
    }

    @Override public synchronized void read() {
        reader.read();
    }
}
