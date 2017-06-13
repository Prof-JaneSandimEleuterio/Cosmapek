package unicamp.buscame.util;

import android.app.Activity;

/**
 * Created by ArchyWin on 8/4/2015.
 */
public class ActivityController implements IActivityController{
    private Activity mainActivity;
    private String mainPackage;

    @Override
    synchronized public void setMainPackage(String mainPackage) {
        this.mainPackage = mainPackage;
    }

    @Override
    synchronized public void setMainActivity(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    synchronized public Activity getMainActivity() {
        return mainActivity;
    }

    @Override
    synchronized public String getMainPackage() {
        return mainPackage;
    }
}
