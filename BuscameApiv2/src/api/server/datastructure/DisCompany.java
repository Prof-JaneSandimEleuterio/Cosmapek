package api.server.datastructure;


import api.server.representation.Company;

/**
 * Created by Junior Cupe on 9/4/2015.
 */
public class DisCompany {

    double position;
    Company company;

    public DisCompany(double distance, Company c) {
        this.position=distance;
        this.company=c;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
