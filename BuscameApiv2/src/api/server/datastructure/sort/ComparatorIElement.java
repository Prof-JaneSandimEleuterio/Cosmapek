package api.server.datastructure.sort;

import api.server.datastructure.DisCompany;

import java.util.Comparator;

/**
 * Created by Junior Cupe on 8/19/2015.
 */
public class ComparatorIElement implements Comparator<DisCompany> {
    public int compare(DisCompany e1, DisCompany e2)
    {

        if (e1.getPosition() > e2.getPosition())
            return 1;
        else if (e1.getPosition() < e2.getPosition())
            return -1;
        else
            return 0;
    }

}
