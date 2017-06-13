package db.entity.client;

import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by Junior Cupe on 8/22/2015.
 */
public class Client {
    @Id
    private Object idObject;
    @Version
    private Object version;

    private long id;
    private String name;
    private String email;
    private int age;
    private ClientConfiguration clientConfiguration;
    private ClientLastLocation clientLastLocation;

    public Client() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ClientConfiguration getClientConfiguration() {
        return clientConfiguration;
    }

    public void setClientConfiguration(ClientConfiguration clientConfiguration) {
        this.clientConfiguration = clientConfiguration;
    }

    public ClientLastLocation getClientLastLocation() {
        return clientLastLocation;
    }

    public void setClientLastLocation(ClientLastLocation clientLastLocation) {
        this.clientLastLocation = clientLastLocation;
    }
}
