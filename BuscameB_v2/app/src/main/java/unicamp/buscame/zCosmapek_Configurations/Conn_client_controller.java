package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_client_controller implements IExecution,IInterfaceTags {
    private unicamp.buscame.client.prov.IManager client;
    private unicamp.buscame.client.prov.IClientManager clientIClient;

    private unicamp.buscame.controller.prov.IManager controller;
    private unicamp.buscame.conn_client_controller.prov.IManager client_controller;
    @Override
    public synchronized void execute() {
        client = unicamp.buscame.client.impl.ComponentFactory.createInstance();
        clientIClient =
                (unicamp.buscame.client.prov.IClientManager) client.getProvidedInterface(IClientManagerTag);

        client_controller = unicamp.buscame.conn_client_controller.impl.ComponentFactory.createInstance();
        client_controller.setRequiredInterface(IClientManagerTag, clientIClient);

        controller = unicamp.buscame.controller.impl.ComponentFactory.createInstance();
        controller.setRequiredInterface(IClientManagerTag,
                client_controller.getProvidedInterface(IClientManagerTag));
    }
}
