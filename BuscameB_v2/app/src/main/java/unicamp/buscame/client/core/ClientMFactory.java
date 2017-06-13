package unicamp.buscame.client.core;

import unicamp.buscame.client.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ClientMFactory {
    private static ClientM clientM = null;

    public static synchronized ClientM createInstance(IManager manager) {
        if (clientM == null)
            clientM = new ClientM(manager);
        return clientM;
    }
}
