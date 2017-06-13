package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by ArchyWin on 8/20/2015.
 */
public class Company implements IExecution,IInterfaceTags {
    private unicamp.buscame.company.prov.IManager company;
    private unicamp.buscame.company.prov.ICompanyManager companyIComp;
    @Override public void execute() {
/*        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        companyIComp =
                (unicamp.buscame.company.prov.ICompanyManager) company.getProvidedInterface(ICompanyManagerTag);
*/
    }
}
