package api.server.representation;

import java.io.Serializable;

public class CompanyOperationHour implements Serializable {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private String id;
    private String beginning;
    private String ending;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getBeginning() {
        return beginning;
    }
    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public String getEnding() {
        return ending;
    }
    public void setEnding(String ending) {
        this.ending = ending;
    }

}
