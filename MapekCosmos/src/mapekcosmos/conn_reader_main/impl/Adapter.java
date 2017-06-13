package mapekcosmos.conn_reader_main.impl;

import mapekcosmos.conn_reader_main.prov.IManager;

class Adapter implements mapekcosmos.main.req.IReadingManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void setConfigurationPath(String configurationPath) {
        mapekcosmos.reader.prov.IReadingManager compReader =
            (mapekcosmos.reader.prov.IReadingManager) this.manager.getRequiredInterface(IReadingManagerTag);
        compReader.setConfigurationPath(configurationPath);
    }

    @Override public synchronized void setVariabilityPath(String variabilityPath) {
        mapekcosmos.reader.prov.IReadingManager compReader =
            (mapekcosmos.reader.prov.IReadingManager) this.manager.getRequiredInterface(IReadingManagerTag);
        compReader.setVariabilityPath(variabilityPath);
    }

    @Override public synchronized void read() {
        mapekcosmos.reader.prov.IReadingManager compReader =
            (mapekcosmos.reader.prov.IReadingManager) this.manager.getRequiredInterface(IReadingManagerTag);
        compReader.read();
    }

}
