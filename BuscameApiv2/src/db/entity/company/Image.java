package db.entity.company;

import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by Junior Cupe on 9/3/2015.
 */
public class Image {
    @Id
    private Object idObject;
    @Version
    private Object version;

    private long id;
    private String dataBase64Encoded;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataBase64Encoded() {
        return dataBase64Encoded;
    }

    public void setDataBase64Encoded(String dataBase64Encoded) {
        this.dataBase64Encoded = dataBase64Encoded;
    }
}
