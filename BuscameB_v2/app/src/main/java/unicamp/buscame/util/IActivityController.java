package unicamp.buscame.util;

import android.app.Activity;

/**
 * @author ArchyWin on 8/5/2015.
 */
public interface IActivityController {
    public void setMainPackage(String mainPackage);

    public void setMainActivity(Activity mainActivity);

    public Activity getMainActivity();
    public String getMainPackage();
}
