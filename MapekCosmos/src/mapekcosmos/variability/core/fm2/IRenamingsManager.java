package mapekcosmos.variability.core.fm2;

/**
 * Created by ArchyWin on 6/4/2015.
 */
public interface IRenamingsManager {

    //    boolean renameFeature(String oldName,String newName);

    String getOldName(String s);

    String getNewName(String var);

    void clear();
}
