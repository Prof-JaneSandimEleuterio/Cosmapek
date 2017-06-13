package mapekcosmos.conn_analyzer_controller.impl;

import mapekcosmos.conn_analyzer_controller.prov.IManager;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

/**
 * Created by ArchyWin on 5/23/2015.
 */
class Manager implements IManager, mapekcosmos.conn_analyzer_controller.impl.IInterfaceTags {

    private Hashtable<String, Object> providedInterfaces = new Hashtable<String, Object>();
    private Hashtable<String, Object> requiredInterfaces = new Hashtable<String, Object>();

    private Hashtable<String, Class<?>> providedInterfacesTypesMap =
        new Hashtable<String, Class<?>>();
    private Hashtable<String, Class<?>> requiredInterfacesTypesMap =
        new Hashtable<String, Class<?>>();

    Manager() {
        //provided
        this.setProvidedInterface(IManagerTag, this);
        this.setProvidedInterfaceTypes(IManagerTag, IManager.class);

        this.setProvidedInterface(IAnalysisManagerTag, new Adapter(this));
        this.setProvidedInterfaceTypes(IAnalysisManagerTag, mapekcosmos.controller.req.IAnalysisManager.class);

        //required
        this.setRequiredInterfaceTypes(IAnalysisManagerTag, mapekcosmos.analyzer.prov.IAnalysisManager.class);
    }

    private void setProvidedInterface(String name, Object facade) {
        providedInterfaces.put(name, facade);
    }

    private void setProvidedInterfaceTypes(String name, Class<?> type) {
        providedInterfacesTypesMap.put(name, type);
    }

    @Override synchronized public void setRequiredInterface(String name, Object facade) {
        requiredInterfaces.put(name, facade);
    }

    //special
    private void setRequiredInterfaceTypes(String name, Class<?> type) {
        this.requiredInterfacesTypesMap.put(name, type);
    }

    @Override synchronized public Object getProvidedInterface(String name) {
        return providedInterfaces.get(name);
    }

    @Override synchronized public Object getRequiredInterface(String name) {
        return requiredInterfaces.get(name);
    }

    @Override synchronized public String[] getProvidedInterfaceNames() {
        return convertEnumToArray(providedInterfacesTypesMap.keys());
    }

    @Override synchronized public String[] getRequiredInterfaceNames() {
        return convertEnumToArray(requiredInterfacesTypesMap.keys());
    }

    @Override synchronized public Map<String, Class<?>> getProvidedInterfaceTypes() {
        return providedInterfacesTypesMap;
    }

    @Override synchronized public Map<String, Class<?>> getRequiredInterfaceTypes() {
        return requiredInterfacesTypesMap;
    }


    private String[] convertEnumToArray(Enumeration<String> stringEnum) {
        Vector<String> stringVector = new Vector<String>();
        for (Enumeration<String> iter = stringEnum; iter.hasMoreElements(); ) {
            String element = (String) iter.nextElement();
            stringVector.addElement(element);
        }

        String[] stringArray = new String[stringVector.size()];
        for (int i = 0; i < stringVector.size(); i++) {
            stringArray[i] = (String) stringVector.elementAt(i);
        }
        return stringArray;
    }
}
