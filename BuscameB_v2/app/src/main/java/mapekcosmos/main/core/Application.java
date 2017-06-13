package mapekcosmos.main.core;

import mapekcosmos.main.prov.IManager;

/**
 * This class has the mapekcosmos.main method.
 *
 * @author Junior Cupe Casquina
 */
public class Application implements IInterfaceTags {
    public static void main(String[] args) {
        //need load each component
        //  boolean tru = true;


        IManager manager = mapekcosmos.main.impl.ComponentFactory.createInstance();
        mapekcosmos.main.prov.ILauncher launcher =
            (mapekcosmos.main.prov.ILauncher) manager.getProvidedInterface(ILauncherProv);
        launcher.start();
    }
}
