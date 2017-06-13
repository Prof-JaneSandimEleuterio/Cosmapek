package unicamp.buscame.ui.core.act.free;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import unicamp.buscame.R;
import unicamp.buscame.ui.core.frag.ItemResult;

public class FreeResult extends Activity {

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_result);

        fm = getFragmentManager();

        if (fm.findFragmentById(R.id.containerFragList) == null) {
            ItemResult list = new ItemResult();
            fm.beginTransaction().add(R.id.containerFragList, list).commit();
        }
/*
    user_image = (ImageView) findViewById(R.id.userImageProfile);
* byte[] decodedString = Base64.decode(person_object.getPhoto(),Base64.NO_WRAP);
InputStream inputStream  = new ByteArrayInputStream(decodedString);
Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
user_image.setImageBitmap(bitmap);
* */
        //draw the companyList
        /*
        * byte[] originalBytes = new byte[] { 1, 2, 3, 4, 5};
// Sending side
byte[] data = text.getBytes("UTF-8");
String base64 = Base64.encodeToString(data, Base64.DEFAULT);

// Receiving side
byte[] data = Base64.decode(base64, Base64.DEFAULT);
String text = new String(data, "UTF-8");

        * */

    /*
    *Intent i = new Intent(this, Actividad2.class);
        i.putExtra("direccion", et1.getText().toString());

                Bundle bundle = getIntent().getExtras();
        webView1.loadUrl("http://" + bundle.getString("direccion"));
    *
    * */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_free_result, menu);
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
