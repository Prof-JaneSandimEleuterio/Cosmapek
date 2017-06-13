package unicamp.buscame.util;

/**
 * Created by ArchyWin on 8/4/2015.
 */
public class ActivityControllerFactory {
    private static ActivityController activityC = null;

    public static ActivityController createInstance() {
        if (activityC == null)
            activityC = new ActivityController();
        return activityC;
    }
}
