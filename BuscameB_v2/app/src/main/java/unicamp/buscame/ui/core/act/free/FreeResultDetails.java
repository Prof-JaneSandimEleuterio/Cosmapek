package unicamp.buscame.ui.core.act.free;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import unicamp.buscame.R;
import unicamp.buscame.ui.core.frag.ItemResult;
import unicamp.buscame.ui.core.frag.OperationHour;
import unicamp.buscame.ui.core.frag.Product;
import unicamp.buscame.ui.impl.ComponentFactory;
import unicamp.buscame.ui.prov.IManager;
import unicamp.buscame.ui.req.ICompanyManager;
import unicamp.buscame.util.representation.CompanyDetails;
import unicamp.buscame.util.representation.CompanyOperationHour;
import unicamp.buscame.util.representation.CompanyOperationHourList;
import unicamp.buscame.util.representation.CompanyProduct;
import unicamp.buscame.util.representation.CompanyProductList;

public class FreeResultDetails extends Activity {
    private IManager managerUi;
    private ICompanyManager companyManager;
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_result_details);
        this.managerUi= ComponentFactory.createInstance();
        this.companyManager =
                (ICompanyManager) this.managerUi.getRequiredInterface("ICompanyManager");


        Bundle bundle = getIntent().getExtras();
        String companyId=bundle.getString("idCompany");
        //draw the details

        CompanyDetails companyDetails=companyManager.getCompanyDetails(companyId);
        CompanyOperationHourList companyOperationHourList=companyManager.getOperationHourList(companyId);
        //sentences for to create the fragment with the data
        fm = getFragmentManager();
        if(companyOperationHourList!=null){
            for (CompanyOperationHour compHours:companyOperationHourList){
                OperationHour tem=OperationHour.newInstance(compHours.getBeginning(),compHours.getEnding());
                fm.beginTransaction().add(R.id.containerListA,tem).commit();
            }
        }
        //fm.beginTransaction().add(R.id.containerList, l).commit();
        CompanyProductList companyProductList= companyManager.getCompanyProductList(companyId);
        if(companyProductList!=null){
            //sentences for to create the fragment with the data
            for (CompanyProduct compProduct:companyProductList){
                Product p=Product.newInstance(compProduct.getId(),compProduct.getName(),compProduct.getDataBase64Encoded(), compProduct.getDescription());
                fm.beginTransaction().add(R.id.containerListB, p).commit();
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_free_result_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
