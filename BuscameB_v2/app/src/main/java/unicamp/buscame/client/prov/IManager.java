package unicamp.buscame.client.prov;

import java.util.Map;

public interface IManager {
    /*
    private void setProvidedInterface(String name, Object facade); //internal and private use (*)
    private void setProvidedInterfaceTypes(String name, Class<?> type); //internal and private use
    */
    public void setRequiredInterface(String name, Object facade); //external use (important)
    //private void setRequiredInterfaceTypes(String name, Class<?> type);

    public Object getProvidedInterface(String name); //external use (important)

    public Object getRequiredInterface(String name); //internal use (important)

    public String[] getProvidedInterfaceNames(); //external use

    public String[] getRequiredInterfaceNames(); //internal and external use

    public Map<String, Class<?>> getProvidedInterfaceTypes(); //external use

    public Map<String, Class<?>> getRequiredInterfaceTypes(); //internal and external use

}
