package api.server.resource.impl;

import api.server.datastructure.*;
import api.server.datastructure.sort.DefaultAlgorithm;
import api.server.datastructure.sort.Sort;
import api.server.representation.CompanyList;
import api.server.resource.prov.CompaniesResource;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import db.entity.company.Company;
import db.entity.company.CompanyConfiguration;
import db.entity.company.CompanyLastLocation;
import db.main.DBConfiguration;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class CompaniesServerResource extends AbstractServerResource implements CompaniesResource, DBConfiguration {

    @Override public CompanyList getACompanyList() throws Exception {
        String paramLongitude = getQueryValue("longitude");
        String paramLatitude = getQueryValue("latitude");
        String paramNum = getQueryValue("num");

        OObjectDatabaseTx db = new OObjectDatabaseTx(remoteServer).open("root",
                "cupecupe");
        QuadTree<Double,Company> quadTree= QuadTreeFactory.createInstance();
        Double longitude = 10.d;//initialize
        Double latitude = 10.d;//initialize
        int num = 10;//initialize

        //parameters
        longitude = Double.parseDouble(paramLongitude);
        latitude = Double.parseDouble(paramLongitude);
        num = Integer.parseInt(paramNum);

        Double xmin = longitude - 100.0;
        Double ymin = latitude - 100.0;
        Double xmax = longitude + 100.0;
        Double ymax = latitude + 100.0;

        Interval1D<Double> intX = new Interval1D<Double>(xmin, xmax);
        Interval1D<Double> intY = new Interval1D<Double>(ymin, ymax);
        Interval2D<Double> rect = new Interval2D<Double>(intX, intY);

        LinkedList<Company> companyLinkedList=quadTree.query2DB(rect);//query to the structure.
        LinkedList<DisCompany> companySolution=new LinkedList<DisCompany>();
        CompanyList result=new CompanyList();

        for(Company c:companyLinkedList){
            CompanyLastLocation locC=c.getCompanyLastLocation();
            double distance=distFrom(latitude, longitude, locC.getLatitude(), locC.getLongitude());
            api.server.representation.Company comp=new api.server.representation.Company();

            comp.setId(Long.toString(c.getId()));
            comp.setName(c.getName());
            comp.setDataBase64Encoded(c.getImageAddress().getDataBase64Encoded());
            CompanyConfiguration conf=c.getCompanyConfiguration();
            if(conf.isOpen()){
                comp.setColor("3283C5");
            }else{
                comp.setColor("D23E26");
            }
            comp.setDescription(c.getDescription());

            companySolution.add(new DisCompany(distance,comp));

        }
        Sort s = new DefaultAlgorithm();
        s.sort(companySolution);
        int max=num;
        for(DisCompany d:companySolution){
            if(max<=0){
                break;
            }else{
                result.add(d.getCompany());
                max--;
            }

        }
/*
        List<Company> result = db.query(
                new OSQLSynchQuery<Company>("select * from Animal where ID = 10 and name like 'G%'"));*/
        return result;
    }
    private double distFrom(double lat1, double lng1, double lat2, double lng2) {
        //double earthRadius = 3958.75;//miles
       // double earthRadius = 6371;//kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
      //  double dist = earthRadius * c;

        return c;
    }
}
