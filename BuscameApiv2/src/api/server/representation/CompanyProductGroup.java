package api.server.representation;

import java.io.Serializable;
import java.util.ArrayList;

public class CompanyProductGroup implements Serializable {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private java.util.List<String> productList;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public java.util.List<String> getProductList() {
        if (productList == null) {
            productList = new ArrayList<String>();
        }
        return productList;
    }
    public void setProductList(java.util.List<String> productList) {
        this.productList = productList;
    }

}
