package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_client_ui implements IExecution,IInterfaceTags {
    private unicamp.buscame.client.prov.IManager client;
    private unicamp.buscame.client.prov.IClientManager clientIClient;

    private unicamp.buscame.conn_client_ui.prov.IManager client_ui;
    private unicamp.buscame.ui.prov.IManager ui;

    @Override
    public synchronized void execute() {
        client = unicamp.buscame.client.impl.ComponentFactory.createInstance();
        clientIClient =
                (unicamp.buscame.client.prov.IClientManager) client.getProvidedInterface(IClientManagerTag);

        client_ui= unicamp.buscame.conn_client_ui.impl.ComponentFactory.createInstance();
        client_ui.setRequiredInterface(IClientManagerTag, clientIClient);

        ui = unicamp.buscame.ui.impl.ComponentFactory.createInstance();
        ui.setRequiredInterface(IClientManagerTag,
                client_ui.getProvidedInterface(IClientManagerTag));
    }
}
