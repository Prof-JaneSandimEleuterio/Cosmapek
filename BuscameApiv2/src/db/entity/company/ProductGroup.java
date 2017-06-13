package db.entity.company;

import javax.persistence.Id;
import javax.persistence.Version;
import java.util.Set;

/**
 * Created by Junior Cupe on 8/22/2015.
 */
public class ProductGroup {
    @Id
    private Object idObject;
    @Version
    private Object version;

    private long id;
    private Set<Product> productList;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Set<Product> getProductList() {
        return productList;
    }
    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }
}
