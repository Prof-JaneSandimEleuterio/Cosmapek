package mapekcosmos.interfaces;

/**
 * Created by ArchyWin on 5/26/2015.
 */
public interface ISensor extends IElement {
    boolean isActivated();

    String getFeatureName();

    void setIsActivated(boolean b);
}
