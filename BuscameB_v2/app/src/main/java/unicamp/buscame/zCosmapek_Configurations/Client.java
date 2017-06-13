package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by ArchyWin on 8/20/2015.
 */
public class Client implements IExecution,IInterfaceTags {
    private unicamp.buscame.client.prov.IManager client;
    private unicamp.buscame.client.prov.IClientManager clientIClient;
    @Override public void execute() {
/*        client = unicamp.buscame.client.impl.ComponentFactory.createInstance();
        clientIClient =
                (unicamp.buscame.client.prov.IClientManager) client.getProvidedInterface(IClientManagerTag);
*/
    }
}
