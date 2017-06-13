package mapekcosmos.executer.req;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 5/25/2015.
 */
public interface IPlanningManager {
    void start();

    LinkedList<String> getComponents();
}
