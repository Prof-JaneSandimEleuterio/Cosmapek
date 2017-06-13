package api.server.datastructure.sort;

import api.server.datastructure.DisCompany;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface Sort {
    public LinkedList<DisCompany> sort(LinkedList<DisCompany> input);
}
