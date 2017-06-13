package api.server.resource.impl;

import api.server.representation.CompanyProduct;
import api.server.representation.CompanyProductList;
import api.server.resource.prov.Companies_id_Products_Resource;
import api.server.utils.PathVariableUtils;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import db.main.DBConfiguration;
import org.restlet.data.Reference;

import java.util.List;
import java.util.Set;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Companies_id_Products_ServerResource extends AbstractServerResource implements
    Companies_id_Products_Resource, DBConfiguration {
    @Override public CompanyProductList getCompanyProducts() throws Exception {
        String IdPathVariable = Reference.decode(getAttribute("companyId"));
        PathVariableUtils.checkLong("companyId", IdPathVariable);
        long companyId=Long.parseLong(IdPathVariable);
        OObjectDatabaseTx database = new OObjectDatabaseTx(remoteServer).open("root",
                "cupecupe");
        String query="select productSet from Company where id = '"+companyId+"'";
        CompanyProductList resp=new CompanyProductList();

        List<ODocument> result=database.query(new OSQLSynchQuery<ODocument>(query));
        for(ODocument doc:result){
            Set<ODocument> a=doc.field("productSet");
            for(ODocument ate:a){
                CompanyProduct item = new CompanyProduct();
                item.setId(ate.field("id").toString());
                item.setName(ate.field("name"));
                item.setDescription(ate.field("description"));
                ODocument img=ate.field("imageAddress");
                item.setDataBase64Encoded(img.field("dataBase64Encoded"));
                resp.add(item);
            }
        }
        return resp;
    }

    @Override public void removeAllCompanyProducts() throws Exception {

    }

    @Override public CompanyProduct addACompanyProduct(CompanyProduct bean) throws Exception {
        return null;
    }
}


