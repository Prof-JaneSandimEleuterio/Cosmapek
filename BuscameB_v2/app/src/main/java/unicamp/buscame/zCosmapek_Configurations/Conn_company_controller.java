package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_company_controller implements IExecution,IInterfaceTags {
    private unicamp.buscame.company.prov.IManager company;
    private unicamp.buscame.company.prov.ICompanyManager companyIComp;

    private unicamp.buscame.conn_company_controller.prov.IManager company_controller;
    private unicamp.buscame.controller.prov.IManager controller;
    @Override
    public synchronized void execute() {
        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        companyIComp =
                (unicamp.buscame.company.prov.ICompanyManager) company.getProvidedInterface(ICompanyManagerTag);

        company_controller=unicamp.buscame.conn_company_controller.impl.ComponentFactory.createInstance();
        company_controller.setRequiredInterface(ICompanyManagerTag, companyIComp);

        controller = unicamp.buscame.controller.impl.ComponentFactory.createInstance();
        controller.setRequiredInterface(ICompanyManagerTag,
                company_controller.getProvidedInterface(ICompanyManagerTag));
    }
}
