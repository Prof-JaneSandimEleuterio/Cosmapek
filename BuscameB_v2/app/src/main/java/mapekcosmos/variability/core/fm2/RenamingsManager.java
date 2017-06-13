package mapekcosmos.variability.core.fm2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ArchyWin on 6/4/2015.
 */
public class RenamingsManager implements IRenamingsManager {
    private final List<Renaming> renamings = new LinkedList<Renaming>();
    private final IFeatureModel model;

    public RenamingsManager(IFeatureModel featureModel) {
        this.model = featureModel;

    }

    /*
        @Override public boolean renameFeature(String oldName, String newName) {
                Map<String, Feature> featureTable = model.getFeatureTable();
                if (!featureTable.containsKey(oldName)
                    || featureTable.containsKey(newName)) {
                    return false;
                }
                final List<Constraint> constraints = model.getConstraints();
                final List<String> featureOrderList = model.getFeatureOrderList();
                Feature feature = featureTable.remove(oldName);
                feature.setName(newName);
                featureTable.put(newName, feature);
                renamings.add(new Renaming(oldName, newName));
                for (Constraint c : constraints) {
                    renameVariables(c.getNode(), oldName, newName);
                }

                // update the feature order list
                for (int i = 0;i < featureOrderList.size();i++) {
                    if (featureOrderList.get(i).equals(oldName)) {
                        featureOrderList.set(i, newName);
                        break;
                    }
                }
                return true;

        }
    */
    @Override public String getOldName(String s) {
        for (Renaming renaming : renamings) {
            if (renaming.getNewName().equals(s)) {
                return renaming.getOldName();
            }
        }
        return s;
    }

    @Override public String getNewName(String var) {
        for (Renaming renaming : renamings) {
            if (renaming.getOldName().equals(var)) {
                return renaming.getNewName();
            }
        }
        return var;
    }

    @Override public void clear() {
        renamings.clear();
    }
}
