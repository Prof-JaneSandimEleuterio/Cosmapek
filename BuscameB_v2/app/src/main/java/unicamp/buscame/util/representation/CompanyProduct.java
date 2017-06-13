package unicamp.buscame.util.representation;

import java.io.Serializable;

/**
 * @author ArchyWin on 9/3/2015.
 */
public class CompanyProduct implements Serializable {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;
    private String id;
    private String dataBase64Encoded;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataBase64Encoded() {
        return dataBase64Encoded;
    }

    public void setDataBase64Encoded(String dataBase64Encoded) {
        this.dataBase64Encoded = dataBase64Encoded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
