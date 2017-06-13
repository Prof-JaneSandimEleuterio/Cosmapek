package unicamp.buscame.client.core;

/**
 * Created by ArchyWin on 8/31/2015.
 */
public class ClientLocalizationFactory {
    private static ClientLocalization clientLocalization = null;

    public static synchronized ClientLocalization createInstance() {
        if (clientLocalization == null)
            clientLocalization = new ClientLocalization();
        return clientLocalization;
    }
}
