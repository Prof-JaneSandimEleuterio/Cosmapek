package api.server.representation;

import java.io.Serializable;

public class Image implements Serializable {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private String dataBase64Encoded;

    public String getDataBase64Encoded() {
        return dataBase64Encoded;
    }

    public void setDataBase64Encoded(String dataBase64Encoded) {
        this.dataBase64Encoded = dataBase64Encoded;
    }
}
