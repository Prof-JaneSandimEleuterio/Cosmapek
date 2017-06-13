package unicamp.buscame.ui.core.frag;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import unicamp.buscame.ui.core.ListViewAdapter;
import unicamp.buscame.ui.core.ListViewItem;
import unicamp.buscame.ui.core.act.free.FreeResult;
import unicamp.buscame.ui.core.act.free.FreeResultDetails;
import unicamp.buscame.ui.impl.ComponentFactory;
import unicamp.buscame.ui.prov.IManager;
import unicamp.buscame.ui.req.IClientManager;
import unicamp.buscame.ui.req.ICompanyManager;
import unicamp.buscame.util.ActivityController;
import unicamp.buscame.util.ActivityControllerFactory;
import unicamp.buscame.util.representation.ClientLocation;
import unicamp.buscame.util.representation.Company;
import unicamp.buscame.util.representation.CompanyList;

public class ItemResult extends ListFragment {
    private List<ListViewItem> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItems = new ArrayList<ListViewItem>();

        IManager managerUi= ComponentFactory.createInstance();
        IClientManager clientManager = (IClientManager) managerUi.getRequiredInterface("IClientManager");
        ClientLocation clientLocation = clientManager.getDefaultLocalization();

        ICompanyManager companyManager = (ICompanyManager) managerUi.getRequiredInterface("ICompanyManager");
        int numCompanies=20;
        CompanyList companyList = companyManager.getCompanyList(Double.parseDouble(clientLocation.getLongitude()),Double.parseDouble(clientLocation.getLatitude()),numCompanies);

        mItems.clear();
        for(Company c:companyList){
            // initialize the items list
            byte[] decodedString = Base64.decode(c.getDataBase64Encoded(),Base64.DEFAULT);
            InputStream inputStream  = new ByteArrayInputStream(decodedString);
            Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
            int color = Color.parseColor("#" + c.getColor());
            ListViewItem temp= new ListViewItem(c.getId(),bitmap, c.getName(),c.getDescription(),color);
            mItems.add(temp);
        }
        // initialize and set the list adapter
        setListAdapter(new ListViewAdapter(getActivity(), mItems));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        ListViewItem item = mItems.get(position);

        // do something
        //Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
        //call the ResultDetails
        ActivityController activityController;
        activityController= ActivityControllerFactory.createInstance();
        Activity m=activityController.getMainActivity();
        Intent intent = new Intent();
        intent.putExtra("idCompany",item.id);
        String pkgName = activityController.getMainPackage();
        String className = FreeResultDetails.class.getName();
        intent.setClassName(pkgName, className);
        m.startActivity(intent);
    }


}
