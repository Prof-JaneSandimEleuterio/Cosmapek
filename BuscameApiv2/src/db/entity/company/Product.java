package db.entity.company;

import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by Junior Cupe on 8/22/2015.
 */
public class Product {
    @Id
    private Object idObject;
    @Version
    private Object version;

    private long id;
    private String name;
    private String description;
    private Image imageAddress;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Image getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(Image imageAddress) {
        this.imageAddress = imageAddress;
    }
}
