package mapekcosmos.planner.core.sort;

import mapekcosmos.interfaces.IElement;

import java.util.Comparator;

/**
 * Created by ArchyWin on 8/19/2015.
 */
public class ComparatorIElement implements Comparator<IElement> {
    public int compare(IElement e1, IElement e2)
    {
        if((e1.getName().equals(e2.getName())) && (e1.getPosition()==e2.getPosition())){
            return 0;
        }
        if(e1.getPosition() > e2.getPosition()){
            return 1;
        }else{
            return -1;
        }

    }

}
