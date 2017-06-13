package db.main;


import api.server.datastructure.QuadTree;
import api.server.datastructure.QuadTreeFactory;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import db.entity.client.Client;
import db.entity.company.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FillDataBase_B implements DBConfiguration {

    public  void insertSetElements() {

        OObjectDatabaseTx database = new OObjectDatabaseTx(remoteServerB).open("root",
                "cupecupe");
        database.getEntityManager().registerEntityClasses("db.entity.client");
        database.getEntityManager().registerEntityClasses("db.entity.company");
        database.getEntityManager().registerEntityClasses("db.entity.general");

        FillDB abc=new FillDB();
        Set<Company> companies= abc.generateCompany(10, 5);// in there we register the localization in the Quadtree;

        for(Company c:companies){
            database.begin();
            database.save(c);
            database.commit();

        }
        database.close();

    }

    /**
     * Created by Junior on 9/5/2015.
     */
    public  class FillDB {
        public  Set<Client> generateClient(int numC){
            Set<Client> result=new TreeSet<>();
            for(int i=0;i<numC;i++){
                Client client=new Client();
                result.add(client);
            }
            return result;
        }

        public  Set<Company> generateCompany(int numC, int numP){
            QuadTree<Double,Company> quadTree= QuadTreeFactory.createInstance();
            Set<Company> result=new HashSet<>();
            for(int i=0;i<numC;i++){
                Company comp=new Company();
                //fill
                comp.setId(i * 1000);
                comp.setName("CompanyName " + i);
                comp.setDescription("CompanyDescription " + i);
                Image img=generateImageC(i);
                comp.setImageAddress(img);
                Set<Product> products=generateProduct(10);
                comp.setProductSet(products);
                Set<CompanyAttentionHour> companyAttentionHours=generateCompanyAttentionHours(2, i);
                comp.setCompanyAttentionHours(companyAttentionHours);
                CompanyConfiguration conf=generateCompanyConfiguration(1000,true,true);
                comp.setCompanyConfiguration(conf);
                CompanyLastLocation location=generateCompanyLastLocation(-22.81648912+i,-47.0721033+i);
                comp.setCompanyLastLocation(location);

                //
                quadTree.insert(-22.81648912 + i, -47.0721033+ i, comp);
                result.add(comp);

            }
            return result;
        }
        public  Set<Product> generateProduct(int numP){
            Set<Product> result=new HashSet<>();
            for(int i=0;i<numP;i++){
                Product product=new Product();
                product.setId(10 * i);
                product.setName("ProductName" + i);
                product.setDescription("ProductDescription " + i);
                Image img=generateImageP(i);
                product.setImageAddress(img);
                result.add(product);
            }
            return result;
        }
        public  String generateEncoded(String path){
            File file = new File(path);
            String imgEncoded=null;
            try {
                FileInputStream imageInFile = new FileInputStream(file);
                byte imageData[] = new byte[(int) file.length()];
                imageInFile.read(imageData);
                imgEncoded = Base64.getEncoder().encodeToString(imageData);
            }catch (FileNotFoundException e) {
                System.out.println("Image not found" + e);
            } catch (IOException ioe) {
                System.out.println("Exception while reading the Image " + ioe);
            }
            return imgEncoded;
        }
        public Image generateImageC(int i){
            Image img=new Image();
            img.setId(i * 10);
           // String newPath= System.getProperty("user.dir")+ File.separator+"src"+File.separator+"db"+File.separator + "utils" + File.separator+ "imgCompany"+File.separator+"images_";
            String newPath= System.getProperty("user.dir")+File.separator+"db"+File.separator + "utils" + File.separator+ "imgCompany"+File.separator+"images_";
            String imgS =generateEncoded(newPath+i+".jpg");
            img.setDataBase64Encoded(imgS);
            return img;
        }
        public Image generateImageP(int i){
            Image img=new Image();
            img.setId(i * 10);
           // String newPath= System.getProperty("user.dir")+ File.separator+"src"+File.separator+"db"+File.separator + "utils" + File.separator+ "imgProduct"+File.separator+"images_";
            String newPath= System.getProperty("user.dir")+File.separator+"db"+File.separator + "utils" + File.separator+ "imgProduct"+File.separator+"images_";
            String imgS =generateEncoded(newPath+i+".jpg");
            img.setDataBase64Encoded(imgS);
            return img;
        }
        public  Set<CompanyAttentionHour> generateCompanyAttentionHours(int num, int i){
            Set<CompanyAttentionHour> result=new HashSet<>();
            for(int j=0;j<num;j++) {
                CompanyAttentionHour companyAttentionHour = new CompanyAttentionHour();
                companyAttentionHour.setBeginHour(i);
                companyAttentionHour.setBeginMinute(i * 10);
                companyAttentionHour.setEndingHour(i + 1);
                companyAttentionHour.setEndingMinute(0);
                result.add(companyAttentionHour);
            }
            return result;
        }
        public CompanyConfiguration generateCompanyConfiguration(long timeLapse,boolean acceptMonitor,boolean open){
            CompanyConfiguration companyConfiguration=new CompanyConfiguration();
            companyConfiguration.setOpen(open);
            companyConfiguration.setTimeLapse(timeLapse);
            companyConfiguration.setAcceptMonitor(acceptMonitor);
            return companyConfiguration;
        }
        public CompanyLastLocation generateCompanyLastLocation(double latitude, double longitude){
            CompanyLastLocation companyLastLocation=new CompanyLastLocation();
            companyLastLocation.setLatitude(latitude);
            companyLastLocation.setLongitude(longitude);
            return companyLastLocation;
        }

    }
}
