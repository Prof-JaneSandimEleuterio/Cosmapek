package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_company_ui implements IExecution,IInterfaceTags {
    private unicamp.buscame.company.prov.IManager company;
    private unicamp.buscame.company.prov.ICompanyManager companyIComp;

    private unicamp.buscame.conn_company_ui.prov.IManager company_ui;
    private unicamp.buscame.ui.prov.IManager ui;
    @Override
    public synchronized void execute() {
        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        companyIComp =
                (unicamp.buscame.company.prov.ICompanyManager) company.getProvidedInterface(ICompanyManagerTag);

        company_ui= unicamp.buscame.conn_company_ui.impl.ComponentFactory.createInstance();
        company_ui.setRequiredInterface(ICompanyManagerTag, companyIComp);

        ui = unicamp.buscame.ui.impl.ComponentFactory.createInstance();
        ui.setRequiredInterface(ICompanyManagerTag,
                company_ui.getProvidedInterface(ICompanyManagerTag));
    }
}
