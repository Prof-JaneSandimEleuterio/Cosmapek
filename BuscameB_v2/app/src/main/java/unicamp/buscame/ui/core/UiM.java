package unicamp.buscame.ui.core;

import android.app.Activity;
import android.content.Intent;

import unicamp.buscame.ui.core.act.free.FreeLocalization;
import unicamp.buscame.ui.core.act.free.FreeMain;
import unicamp.buscame.ui.core.act.free.FreeResult;
import unicamp.buscame.ui.core.act.free.FreeResultDetails;
import unicamp.buscame.ui.prov.IManager;
import unicamp.buscame.ui.req.ICompanyManager;
import unicamp.buscame.util.ActivityController;
import unicamp.buscame.util.ActivityControllerFactory;

/**
 * @author Junior Cupe Casquina
 */
public class UiM {
    private IManager manager;
    private ICompanyManager companyManager;
    private ActivityController activityController;


    public UiM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
        this.companyManager =
                (ICompanyManager) manager.getRequiredInterface("ICompanyManager");
        this.activityController = ActivityControllerFactory.createInstance();
    }

    public boolean createFreeMainUI() {
        getManagers();
        Activity m=activityController.getMainActivity();
        Intent intent = new Intent();
        String pkgName = activityController.getMainPackage();
        String className = FreeMain.class.getName();
        intent.setClassName(pkgName, className);
        m.startActivity(intent);
        return true;
    }

    public boolean createFreeLocalizationUI() {
        getManagers();
        Activity m=activityController.getMainActivity();
        Intent intent = new Intent();
        String pkgName = activityController.getMainPackage();
        String className = FreeLocalization.class.getName();
        intent.setClassName(pkgName, className);
        m.startActivity(intent);
        return true;
    }

    public boolean createFreeResultUI() {
        getManagers();
        Activity m=activityController.getMainActivity();
        Intent intent = new Intent();
        String pkgName = activityController.getMainPackage();
        String className = FreeResult.class.getName();
        intent.setClassName(pkgName, className);
        m.startActivity(intent);
        return true;
    }

    public boolean createFreeResultDetailsUI() {
        getManagers();
        Activity m=activityController.getMainActivity();
        Intent intent = new Intent();
        String pkgName = activityController.getMainPackage();
        String className = FreeResultDetails.class.getName();
        intent.setClassName(pkgName, className);
        m.startActivity(intent);
        return true;
    }
}
