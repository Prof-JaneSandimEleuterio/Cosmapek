package unicamp.buscame.ui.core.act.free;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import unicamp.buscame.R;
import unicamp.buscame.ui.impl.ComponentFactory;
import unicamp.buscame.ui.prov.IManager;
import unicamp.buscame.ui.req.IClientManager;
import unicamp.buscame.ui.req.ICompanyManager;
import unicamp.buscame.util.ActivityController;
import unicamp.buscame.util.ActivityControllerFactory;

public class FreeMain extends Activity {
    private IManager managerUi;
    private ICompanyManager companyManager;
    private IClientManager clientManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_main);
        this.managerUi=ComponentFactory.createInstance();
        this.companyManager =
                (ICompanyManager) this.managerUi.getRequiredInterface("ICompanyManager");
        this.clientManager= (IClientManager) this.managerUi.getRequiredInterface("IClientManager");

        //define a localization. If not have a localization send my current localization.
        if(!clientManager.hasDefaultLocation()){
            clientManager.setDefaultLocalization();
        }

        ImageButton imageBut_localization = (ImageButton) findViewById(R.id.id_imgBut_Localization);
        ImageButton imageBut_search = (ImageButton) findViewById(R.id.id_imgBut_Search);
        imageBut_localization.setOnTouchListener(
                new View.OnTouchListener(){
                    public boolean onTouch(View v, MotionEvent event){
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            ActivityController activityController;
                            activityController= ActivityControllerFactory.createInstance();
                            Activity m=activityController.getMainActivity();
                            Intent intent = new Intent();
                            String pkgName = activityController.getMainPackage();
                            String className = FreeLocalization.class.getName();
                            intent.setClassName(pkgName, className);
                            m.startActivity(intent);
                            //startActivity(new Intent(getApplicationContext(), FreeLocalization.class));

                        }
                        return true;
                    }
                }
        );
        imageBut_search.setOnTouchListener(
                new View.OnTouchListener(){
                    public boolean onTouch(View v, MotionEvent event){
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            ActivityController activityController;
                            activityController= ActivityControllerFactory.createInstance();
                            Activity m=activityController.getMainActivity();
                            Intent intent = new Intent();
                            String pkgName = activityController.getMainPackage();
                            String className = FreeResult.class.getName();
                            intent.setClassName(pkgName, className);
                            m.startActivity(intent);
                            //startActivity(intent);
                            //startActivity(new Intent(getApplicationContext(), FreeResult.class));

                        }
                        return true;
                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_free_main, menu);
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
