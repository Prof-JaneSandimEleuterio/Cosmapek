package mapekcosmos.planner.core.sort;

import mapekcosmos.interfaces.IElement;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface Sort {
    public LinkedList<IElement> sort(LinkedList<IElement> input);
}
