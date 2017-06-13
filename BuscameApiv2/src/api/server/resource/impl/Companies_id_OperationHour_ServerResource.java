package api.server.resource.impl;

import api.server.representation.CompanyOperationHour;
import api.server.representation.CompanyOperationHourList;
import api.server.resource.prov.Companies_id_OperationHour_Resource;
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
public class Companies_id_OperationHour_ServerResource extends AbstractServerResource implements
    Companies_id_OperationHour_Resource, DBConfiguration {
    @Override public CompanyOperationHourList getCompanyOperationHours() throws Exception {
        String IdPathVariable = Reference.decode(getAttribute("companyId"));
        PathVariableUtils.checkLong("companyId", IdPathVariable);
        long companyId=Long.parseLong(IdPathVariable);

        OObjectDatabaseTx database = new OObjectDatabaseTx(remoteServer).open("root",
                "cupecupe");
        String query="select companyAttentionHours from Company where id = '"+companyId+"'";
        List<ODocument> result=database.query(new OSQLSynchQuery<ODocument>(query));

        CompanyOperationHourList resp=new CompanyOperationHourList();
        for(ODocument doc:result){
            Set<ODocument> a=doc.field("companyAttentionHours");
            for(ODocument ate:a){
                CompanyOperationHour item=new CompanyOperationHour();
                item.setBeginning(ate.field("beginHour").toString() + ":" + ate.field("beginMinute").toString());
                item.setEnding(ate.field("endingHour").toString() + ":" + ate.field("endingMinute").toString());
                resp.add(item);
            }
        }
        return resp;
    }

    @Override public void removeAllCompanyOperationHours() throws Exception {

    }

    @Override public CompanyOperationHour addAnOperationHour(CompanyOperationHour bean)
        throws Exception {
        return null;
    }
}
