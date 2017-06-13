package db.entity.company;

import javax.persistence.Id;
import javax.persistence.Version;
import java.util.Set;

/**
 * Created by Junior Cupe on 8/22/2015.
 */
public class Company {
    @Id
    private Object idObject;
    @Version
    private Object version;

    private long id;
    private String name;
    private String description;
    private Image imageAddress;
    private Set<Product> productSet;

    private Set<CompanyAttentionHour> companyAttentionHours;
    private CompanyConfiguration companyConfiguration;
    private CompanyLastLocation companyLastLocation;

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

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public Set<CompanyAttentionHour> getCompanyAttentionHours() {
        return companyAttentionHours;
    }

    public void setCompanyAttentionHours(Set<CompanyAttentionHour> companyAttentionHours) {
        this.companyAttentionHours = companyAttentionHours;
    }

    public CompanyConfiguration getCompanyConfiguration() {
        return companyConfiguration;
    }

    public void setCompanyConfiguration(CompanyConfiguration companyConfiguration) {
        this.companyConfiguration = companyConfiguration;
    }

    public CompanyLastLocation getCompanyLastLocation() {
        return companyLastLocation;
    }

    public void setCompanyLastLocation(CompanyLastLocation companyLastLocation) {
        this.companyLastLocation = companyLastLocation;
    }
}
